package com.thendral.android.influx.onlineorder.databinding;
import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class TestLayoutFoodItemBinding extends LayoutFoodItemBinding  {

    @Nullable
    private static final IncludedLayouts sIncludes;
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
    public final android.widget.LinearLayout actionLayout;
    @NonNull
    public final android.widget.Button addItem;
    @NonNull
    public final android.widget.TextView foodCost;
    @NonNull
    public final android.widget.TextView foodCount;
    @NonNull
    public final com.thendral.android.onlineorder.util.RoundedImageView foodImage;
    @NonNull
    public final android.widget.TextView foodName;
    @NonNull
    public final android.widget.FrameLayout imageLayout;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final android.widget.Button removeItem;
    @NonNull
    public final android.support.v7.widget.RecyclerView subItems;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public TestLayoutFoodItemBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.actionLayout = (android.widget.LinearLayout) bindings[6];
        this.addItem = (android.widget.Button) bindings[9];
        this.foodCost = (android.widget.TextView) bindings[5];
        this.foodCount = (android.widget.TextView) bindings[8];
        this.foodImage = (com.thendral.android.onlineorder.util.RoundedImageView) bindings[2];
        this.foodName = (android.widget.TextView) bindings[4];
        this.imageLayout = (android.widget.FrameLayout) bindings[1];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.removeItem = (android.widget.Button) bindings[7];
        this.subItems = (android.support.v7.widget.RecyclerView) bindings[3];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
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
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static TestLayoutFoodItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutFoodItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<TestLayoutFoodItemBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.layout_food_item, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static TestLayoutFoodItemBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutFoodItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.thendral.android.influx.onlineorder.R.layout.layout_food_item, null, false), bindingComponent);
    }
    @NonNull
    public static TestLayoutFoodItemBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutFoodItemBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/layout_food_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new TestLayoutFoodItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}