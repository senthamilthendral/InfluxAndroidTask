package com.thendral.android.influx.onlineorder.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.thendral.android.influx.onlineorder.R;

@SuppressWarnings("unchecked")
public class LayoutFoodItemBindingImpl extends TestLayoutFoodItemBinding {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;

    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image_layout, 1);
        sViewsWithIds.put(R.id.food_image, 2);
        sViewsWithIds.put(R.id.sub_items, 3);
        sViewsWithIds.put(R.id.food_name, 4);
        sViewsWithIds.put(R.id.food_cost, 5);
        sViewsWithIds.put(R.id.action_layout, 6);
        sViewsWithIds.put(R.id.remove_item, 7);
        sViewsWithIds.put(R.id.food_count, 8);
        sViewsWithIds.put(R.id.add_item, 9);
    }

    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutFoodItemBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private LayoutFoodItemBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized (this) {
            mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable) {
        boolean variableSet = true;
        return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized (this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }

    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}