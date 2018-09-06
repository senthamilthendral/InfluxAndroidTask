package com.thendral.android.onlineorder.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.databinding.LayoutCartItemBinding;
import com.thendral.android.onlineorder.model.CartItem;
import com.thendral.android.onlineorder.view.viewholder.CartListViewHolder;

import java.util.Map;

/**
 * The Adapter class to load the list of cart Items added so far. It extends the
 * {@link CartListAdapter} and load the each cart Item using {@link CartListViewHolder}.
 * <p>
 * This class gets the list of cart Items, whenever list item is updated it will refresh the
 * recycler View.
 */
public final class CartListAdapter extends RecyclerView.Adapter<CartListViewHolder> {

    private Map<Integer, CartItem> mCartItems;
    private Integer[] mProductIDAsKeys;

    /**
     * Instantiates a new Cart list adapter.
     */
    public CartListAdapter() {

    }

    /**
     * Method  to get the list of cart Items that added
     *
     * @param cartItemList map that holds list of cart items
     */
    public void setListValues(final Map<Integer, CartItem> cartItemList) {
        this.mCartItems = cartItemList;
        if (mCartItems != null) {
            mProductIDAsKeys = mCartItems.keySet().toArray(new Integer[mCartItems.size()]);
        }
        notifyDataSetChanged();
    }

    @Override
    public CartListViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutCartItemBinding layoutCartItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_cart_item, parent, false);
        return new CartListViewHolder(layoutCartItemBinding);
    }

    @Override
    public void onBindViewHolder(final CartListViewHolder holder, final int position) {
        CartItem cartItem = getItem(position);
        String count = String.format(holder.layoutCartItemBinding.cartItemName.getContext().getString(R.string.count_text), cartItem.getCount());
        count = cartItem.getMenuName() + count;
        holder.layoutCartItemBinding.cartItemName.setText(count);
        float totalSum = (cartItem.getCount() * Float.parseFloat(cartItem.getPrize()));
        holder.layoutCartItemBinding.itemSum.setText(String.valueOf(totalSum));
    }

    @Override
    public int getItemCount() {
        if (mCartItems == null || mCartItems.isEmpty()) {
            return 0;
        }
        return mCartItems.size();
    }

    /**
     * Method to get the CartItem from the Map.
     *
     * @param position position of the item in the recycler view
     * @return CartItem retrieved from the map
     */
    private CartItem getItem(final int position) {
        return mCartItems.get(mProductIDAsKeys[position]);
    }
}
