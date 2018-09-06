package com.thendral.android.onlineorder.view.fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.databinding.FragmentHomeBinding;
import com.thendral.android.onlineorder.listeners.OnCartUpdateListener;
import com.thendral.android.onlineorder.model.CartItem;
import com.thendral.android.onlineorder.model.FAndBBaseResponse;
import com.thendral.android.onlineorder.model.FoodList;
import com.thendral.android.onlineorder.util.BottomSheetUtil;
import com.thendral.android.onlineorder.util.OnlineOrderServiceUtil;
import com.thendral.android.onlineorder.view.adapter.CartListAdapter;
import com.thendral.android.onlineorder.view.adapter.MenuSlideViewPagerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * The Fragment class to load the UI. This class extends the {@link Fragment} and this is
 * attached to the Home Activity. This class implements the interface {@link OnCartUpdateListener}
 * to get to know wherever cart item is updated.
 */
public final class HomeFragment extends Fragment implements OnCartUpdateListener {

    private FragmentHomeBinding mFragmentHomeBinding;
    private Map<Integer, CartItem> mCartItemMap;
    private CartListAdapter cartListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        prepareTabs(mFragmentHomeBinding);
        BottomSheetUtil.initBottomSheet(getActivity(), mFragmentHomeBinding);
        setupCartList(mFragmentHomeBinding);
        return mFragmentHomeBinding.getRoot();
    }

    @Override
    public void onMenuAdded(final CartItem cartItem, final String currency) {
        if (mCartItemMap == null) {
            mCartItemMap = new HashMap<>();
        }
        if (mCartItemMap.containsKey(cartItem.getFoodID())) {
            CartItem cartItemInMap = mCartItemMap.get(cartItem.getFoodID());
            cartItemInMap.setCount(cartItemInMap.getCount() + 1);
            mCartItemMap.put(cartItem.getFoodID(), cartItemInMap);
        } else {
            cartItem.setCount(1);
            mCartItemMap.put(cartItem.getFoodID(), cartItem);
        }
        updateTotal(mCartItemMap, currency);
    }

    /**
     * Method to loop through the list of items added to the cart and sum the prize
     *
     * @param cartItemList - list of cart items
     * @param currency     - currency symbol
     */
    private void updateTotal(final Map<Integer, CartItem> cartItemList, final String currency) {
        float sum = 0;
        // Looping through the cartItems and caluclate the sum
        for (Map.Entry<Integer, CartItem> cartItemEntry : cartItemList.entrySet()) {
            CartItem cartItem = cartItemEntry.getValue();
            sum = (sum + cartItem.getCount() * Float.parseFloat(cartItem.getPrize()));
        }
        mFragmentHomeBinding.totalAmount.setText(String.format(getString(R.string.amount_with_currency), currency, String.valueOf(sum)));
        cartListAdapter.setListValues(mCartItemMap);
    }

    @Override
    public void onMenuRemoved(final int menuID, final String currency) {
        if (mCartItemMap.containsKey(menuID)) {
            CartItem cartItem = mCartItemMap.get(menuID);
            cartItem.setCount(cartItem.getCount() - 1);
            if (cartItem.getCount() <= 0) {
                mCartItemMap.remove(menuID);
            }
        }
        // Update the sum of the item price
        updateTotal(mCartItemMap, currency);
    }

    /**
     * Method to add tabs to tab Layout.
     * This method gets the data from service and based on tabs it will render the
     * TabLayout dynamically.
     *
     * @param fragmentHomeBinding binding object reference
     */
    private void prepareTabs(final FragmentHomeBinding fragmentHomeBinding) {
        FAndBBaseResponse fAndBBaseResponse = OnlineOrderServiceUtil.getFoodDataFromLocal(getActivity());
        setUpTabChangeListener(fragmentHomeBinding);
        // Loop through tabs list
        for (FoodList foodList : fAndBBaseResponse.getFoodList()) {
            // Add tabs to the tab layout
            fragmentHomeBinding.tabLayout.addTab(fragmentHomeBinding.tabLayout.newTab().setText(foodList.getTabName()));
        }
        fragmentHomeBinding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        fragmentHomeBinding.pager.setAdapter(new MenuSlideViewPagerAdapter(getActivity(), fAndBBaseResponse.getCurrency(), fAndBBaseResponse.getFoodList(), this));
        fragmentHomeBinding.tabLayout.setupWithViewPager(fragmentHomeBinding.pager);
    }

    /**
     * Method to add the change listener to the Tab Layout.
     * This method updates the Tab Title Ui on its change.
     *
     * @param fragmentHomeBinding binding object reference
     */
    private void setUpTabChangeListener(final FragmentHomeBinding fragmentHomeBinding) {
        fragmentHomeBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LinearLayout tabLayout = (LinearLayout) ((ViewGroup) fragmentHomeBinding.tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
                // Make selected tab item text bold
                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LinearLayout tabLayout = (LinearLayout) ((ViewGroup) fragmentHomeBinding.tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
                // Reset the bold type text
                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.NORMAL);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * Method to set up the cart RecyclerView
     *
     * @param fragmentHomeBinding binding object reference
     */
    private void setupCartList(final FragmentHomeBinding fragmentHomeBinding) {
        if (fragmentHomeBinding.cartList.getLayoutManager() == null) {
            fragmentHomeBinding.cartList.setNestedScrollingEnabled(false);
            fragmentHomeBinding.cartList.setLayoutManager(new GridLayoutManager(fragmentHomeBinding.cartList.getContext(), 1));
        }
        cartListAdapter = new CartListAdapter();
        fragmentHomeBinding.cartList.setAdapter(cartListAdapter);
    }

}
