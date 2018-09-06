package com.thendral.android.onlineorder.view.viewholder;

import android.support.v7.widget.RecyclerView;

import com.thendral.android.influx.onlineorder.databinding.LayoutSubItemBinding;

/**
 * View Holder class to render the row Item. It extends the
 * {@link RecyclerView.ViewHolder}
 */
public final class SubItemViewHolder extends RecyclerView.ViewHolder {

    public LayoutSubItemBinding layoutSubItemBinding;

    /**
     * Public constructor to accept binding object
     *
     * @param layoutSubItemBinding - item of the sub Item
     */
    public SubItemViewHolder(final LayoutSubItemBinding layoutSubItemBinding) {
        super(layoutSubItemBinding.getRoot());
        this.layoutSubItemBinding = layoutSubItemBinding;
    }
}
