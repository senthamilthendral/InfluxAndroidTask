package com.thendral.android.onlineorder.view.viewholder;

import android.support.v7.widget.RecyclerView;

import com.thendral.android.influx.onlineorder.databinding.LayoutCartItemBinding;

/**
 * View Holder class to render the row Item. It extends the
 * {@link RecyclerView.ViewHolder}
 */
public final class CartListViewHolder extends RecyclerView.ViewHolder {

    public LayoutCartItemBinding layoutCartItemBinding;

    /**
     * Public constructor to accept binding object
     *
     * @param layoutCartItemBinding - cart Item Binding object
     */
    public CartListViewHolder(final LayoutCartItemBinding layoutCartItemBinding) {
        super(layoutCartItemBinding.getRoot());
        this.layoutCartItemBinding = layoutCartItemBinding;
    }
}