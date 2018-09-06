package com.thendral.android.onlineorder.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.databinding.LayoutSubItemBinding;
import com.thendral.android.onlineorder.listeners.OnMenuOptionSelectListener;
import com.thendral.android.onlineorder.model.SubItem;
import com.thendral.android.onlineorder.view.viewholder.SubItemViewHolder;

import java.util.List;

/**
 * The type Sub items adapter.
 */
public final class SubItemsAdapter extends RecyclerView.Adapter<SubItemViewHolder> {
    private List<SubItem> mSubItems;
    private int mSelectedItemPosition = 0;
    private OnMenuOptionSelectListener mOnMenuOptionSelectListener;
    private int subMenuPosition;

    /**
     * Instantiates a new Sub items adapter.
     *
     * @param subItems                   the sub items
     * @param position                   the position
     * @param onMenuOptionSelectListener the on menu option select listener
     */
    public SubItemsAdapter(final List<SubItem> subItems, final int position, final OnMenuOptionSelectListener onMenuOptionSelectListener) {
        this.mSubItems = subItems;
        this.subMenuPosition = position;
        this.mOnMenuOptionSelectListener = onMenuOptionSelectListener;
    }

    @Override
    public SubItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutSubItemBinding layoutSubItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_sub_item, parent, false);
        return new SubItemViewHolder(layoutSubItemBinding);
    }

    @Override
    public void onBindViewHolder(final SubItemViewHolder holder, final int position) {
        Context context = holder.layoutSubItemBinding.subItemName.getContext();
        final int holderPosition = holder.getAdapterPosition();
        final SubItem subItem = mSubItems.get(holderPosition);
        holder.layoutSubItemBinding.subItemName.setText(subItem.getName());
        holder.layoutSubItemBinding.subItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedItemPosition = holderPosition;
                mOnMenuOptionSelectListener.onMenuSelected(subMenuPosition, subItem);
                notifyDataSetChanged();
            }
        });
        if (mSelectedItemPosition == holderPosition) {
            mOnMenuOptionSelectListener.onMenuSelected(subMenuPosition, subItem);
            holder.layoutSubItemBinding.subItemLayout.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            holder.layoutSubItemBinding.subItemName.setTextColor(context.getResources().getColor(R.color.colorBlack));
        } else {
            holder.layoutSubItemBinding.subItemLayout.setBackground(context.getResources().getDrawable(R.drawable.background_rectangle));
            holder.layoutSubItemBinding.subItemName.setTextColor(context.getResources().getColor(R.color.light_grey));
        }

    }

    @Override
    public int getItemCount() {
        return mSubItems.size();
    }

}
