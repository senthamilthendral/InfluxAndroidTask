package com.thendral.android.onlineorder.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.databinding.LayoutFoodItemBinding;
import com.thendral.android.onlineorder.listeners.OnCartUpdateListener;
import com.thendral.android.onlineorder.listeners.OnMenuOptionSelectListener;
import com.thendral.android.onlineorder.model.CartItem;
import com.thendral.android.onlineorder.model.FNBList;
import com.thendral.android.onlineorder.model.SubItem;
import com.thendral.android.onlineorder.util.NetworkConnectionUtil;
import com.thendral.android.onlineorder.util.SubItemsRecyclerViewItemDecorator;

import java.util.List;

/**
 * The Food list adapter to load list of Food Items in the Recycler View. This class extends the
 * {@link RecyclerView.Adapter} which accepts the {@link FoodListAdapter.FoodListItemViewHolder} as
 * view holder type. This class also implements the {@link OnMenuOptionSelectListener} to get to notify
 * whenever sub item selection changes.
 */
public final class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodListItemViewHolder> implements OnMenuOptionSelectListener {

    private LayoutFoodItemBinding mLayoutFoodItemBinding;
    private List<FNBList> mFnbLists;
    private String mCurrency;
    private OnCartUpdateListener mOnCartUpdateListener;

    /**
     * Instantiates a new Food list adapter.
     *
     * @param pCurrency            the p currency
     * @param fnbLists             the fnb lists
     * @param onCartUpdateListener the on cart update listener
     */
    public FoodListAdapter(final String pCurrency, final List<FNBList> fnbLists, final OnCartUpdateListener onCartUpdateListener) {
        this.mCurrency = pCurrency;
        this.mFnbLists = fnbLists;
        this.mOnCartUpdateListener = onCartUpdateListener;
    }

    @Override
    public FoodListItemViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        mLayoutFoodItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_food_item, parent, false);
        return new FoodListAdapter.FoodListItemViewHolder(mLayoutFoodItemBinding);
    }

    @Override
    public void onBindViewHolder(final FoodListItemViewHolder holder, final int position) {
        FNBList fnbItem = mFnbLists.get(position);
        Context context = holder.layoutFoodItemBinding.foodImage.getContext();
        if (NetworkConnectionUtil.isInternetAvailable(context)) {
            Picasso.with(context).
                    load(fnbItem.getImageUrl()).placeholder(context.getDrawable(R.drawable.ic_placeholder)).into(holder.layoutFoodItemBinding.foodImage);
        } else {
            holder.layoutFoodItemBinding.foodImage.setImageDrawable(context.getDrawable(R.drawable.ic_placeholder));
        }
        holder.layoutFoodItemBinding.foodName.setText(fnbItem.getName());
        String itemPrice = String.format(holder.layoutFoodItemBinding.foodCost.getContext().getString(R.string.amount_with_currency), mCurrency, fnbItem.getItemPrice());
        holder.layoutFoodItemBinding.foodCost.setText(itemPrice);
        if (Integer.parseInt(fnbItem.getSubItemCount()) > 0) {
            holder.layoutFoodItemBinding.subItems.setVisibility(View.VISIBLE);
            updateSubItems(holder.layoutFoodItemBinding.subItems, fnbItem, position);
        } else {
            holder.layoutFoodItemBinding.subItems.setVisibility(View.GONE);
        }
        setupClickEvent(holder.layoutFoodItemBinding, fnbItem);
    }

    @Override
    public int getItemCount() {
        return mFnbLists.size();
    }

    /**
     * Method be called when sub item got selected.
     * Method responsible for update the price of the product whenever sub Item selection changed
     *
     * @param subMenuPosition the sub menu position
     * @param subItem         the sub item
     */
    @Override
    public void onMenuSelected(int subMenuPosition, SubItem subItem) {
        mFnbLists.get(subMenuPosition).setSelectedSubItem(subItem);
        String amount = String.format(mLayoutFoodItemBinding.foodCost.getContext().getString(R.string.amount_with_currency), mCurrency, subItem.getSubItemPrice());
        mLayoutFoodItemBinding.foodCost.setText(amount);
        mLayoutFoodItemBinding.foodCount.setText(String.valueOf(subItem.getSubItemCount()));
        mLayoutFoodItemBinding.notifyChange();
    }

    /**
     * Food List Item View Holder to populate the Food Item in row
     */
    static class FoodListItemViewHolder extends RecyclerView.ViewHolder {

        private LayoutFoodItemBinding layoutFoodItemBinding;

        private FoodListItemViewHolder(LayoutFoodItemBinding layoutFoodItemBinding) {
            super(layoutFoodItemBinding.getRoot());
            this.layoutFoodItemBinding = layoutFoodItemBinding;
        }
    }

    /**
     * Method to set up the click listener for Adding and removing item
     *
     * @param layoutFoodItemBinding - Binding object of the Food Item Row
     * @param fnbItem               - Food Item from the food list
     */
    private void setupClickEvent(final LayoutFoodItemBinding layoutFoodItemBinding, final FNBList fnbItem) {
        layoutFoodItemBinding.addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SubItem subItem = fnbItem.getSelectedSubItem();
                int currentItemCount = Integer.parseInt(layoutFoodItemBinding.foodCount.getText().toString());
                currentItemCount++;
                layoutFoodItemBinding.foodCount.setText(String.valueOf(currentItemCount));

                CartItem cartItem;
                if (subItem != null) {
                    subItem.setSubItemCount(currentItemCount);
                    cartItem = new CartItem(Integer.parseInt(subItem.getVistaSubFoodItemId()), fnbItem.getName() + " " + subItem.getName(), subItem.getSubItemPrice());
                } else {
                    cartItem = new CartItem(Integer.parseInt(fnbItem.getVistaFoodItemId()), fnbItem.getName(), fnbItem.getItemPrice());
                }
                mOnCartUpdateListener.onMenuAdded(cartItem, mCurrency);
            }
        });
        layoutFoodItemBinding.removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SubItem subItem = fnbItem.getSelectedSubItem();
                int currentItemCount = Integer.parseInt(layoutFoodItemBinding.foodCount.getText().toString());
                if (currentItemCount > 0) {
                    currentItemCount--;
                    layoutFoodItemBinding.foodCount.setText(String.valueOf(currentItemCount));
                    String menuID;
                    if (subItem == null)
                        menuID = fnbItem.getVistaFoodItemId();
                    else {
                        menuID = subItem.getVistaSubFoodItemId();
                        subItem.setSubItemCount(currentItemCount);
                    }
                    mOnCartUpdateListener.onMenuRemoved(Integer.parseInt(menuID), mCurrency);
                }
            }
        });
    }

    /**
     * Method to load the list of subItems for the food Item.
     *
     * @param subItemsListRecyclerView - recycler View added in the food Item View
     * @param fnbList                  - list of food items available for the Tab
     * @param position                 - position of the food Item in the food List.
     */
    private void updateSubItems(final RecyclerView subItemsListRecyclerView, final FNBList fnbList, final int position) {
        if (subItemsListRecyclerView.getLayoutManager() == null) {
            subItemsListRecyclerView.setNestedScrollingEnabled(false);
            GridLayoutManager subItemListLayoutManager = new GridLayoutManager(subItemsListRecyclerView.getContext(), Integer.parseInt(fnbList.getSubItemCount()));
            subItemsListRecyclerView.setLayoutManager(subItemListLayoutManager);
        }
        subItemsListRecyclerView.addItemDecoration(new SubItemsRecyclerViewItemDecorator(16));
        subItemsListRecyclerView.setAdapter(new SubItemsAdapter(fnbList.getSubItems(), position, this));
    }
}
