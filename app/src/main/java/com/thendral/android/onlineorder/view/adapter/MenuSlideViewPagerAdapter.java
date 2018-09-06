package com.thendral.android.onlineorder.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.databinding.AdapterFoodListBinding;
import com.thendral.android.onlineorder.listeners.OnCartUpdateListener;
import com.thendral.android.onlineorder.model.FoodList;
import com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The Menu slide view pager adapter to load pager content. List of food Items will be
 * rendered under each tabs.
 */
public final class MenuSlideViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<FoodList> mFoodList;
    private String mCurrency;
    private OnCartUpdateListener mOnCartUpdateListener;

    /**
     * Menu slide view pager adapter constructor to accept various params.
     *
     * @param context              the context
     * @param currency             the currency
     * @param foodList             the food list
     * @param onCartUpdateListener the on cart update listener
     */
    public MenuSlideViewPagerAdapter(final Context context, final String currency, final ArrayList<FoodList> foodList, OnCartUpdateListener onCartUpdateListener) {
        this.mContext = context;
        this.mOnCartUpdateListener = onCartUpdateListener;
        this.mFoodList = foodList;
        this.mCurrency = currency;
    }

    @Override
    public int getCount() {
        return mFoodList.size();
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final View container, final int position, final Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFoodList.get(position).getTabName();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        // Inflate the page view
        AdapterFoodListBinding adapterFoodListBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_food_list, null, false);
        View tabView = adapterFoodListBinding.getRoot();
        container.addView(tabView);
        tabView.setTag(position);
        // Setting the View model to the binding object
        adapterFoodListBinding.setAppViewModel(new FoodListViewModel(mCurrency, mFoodList.get(position), mOnCartUpdateListener));
        return tabView;
    }
}
