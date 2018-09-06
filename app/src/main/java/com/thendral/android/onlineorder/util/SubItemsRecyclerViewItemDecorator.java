package com.thendral.android.onlineorder.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * The type Sub items recycler view item decorator.
 */
public final class SubItemsRecyclerViewItemDecorator extends RecyclerView.ItemDecoration {
    private int spaceInPixels;

    /**
     * Instantiates a new Sub items recycler view item decorator.
     *
     * @param spaceInPixels the space in pixels
     */
    public SubItemsRecyclerViewItemDecorator(int spaceInPixels) {
        this.spaceInPixels = spaceInPixels;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spaceInPixels;
        outRect.right = spaceInPixels;
        outRect.bottom = spaceInPixels;
        outRect.top = spaceInPixels;
    }
}