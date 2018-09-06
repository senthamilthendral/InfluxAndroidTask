package com.thendral.android.influx.onlineorder.databinding;
import com.thendral.android.influx.onlineorder.R;
import com.thendral.android.influx.onlineorder.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AdapterFoodListBindingImpl extends TestAdapterFoodListBinding {

    @Nullable
    private static final IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AdapterFoodListBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private AdapterFoodListBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.support.v7.widget.RecyclerView) bindings[1]
            );
        this.foodList.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.appViewModel == variableId) {
            setAppViewModel((com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAppViewModel(@Nullable com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel AppViewModel) {
        updateRegistration(0, AppViewModel);
        this.mAppViewModel = AppViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.appViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeAppViewModel((com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeAppViewModel(com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel AppViewModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        com.thendral.android.onlineorder.listeners.OnCartUpdateListener appViewModelGetCardUpdateListener = null;
        java.util.List<com.thendral.android.onlineorder.model.FNBList> appViewModelGetFoodList = null;
        com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel appViewModel = mAppViewModel;
        java.lang.String appViewModelGetCurrency = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (appViewModel != null) {
                    // read appViewModel.getCardUpdateListener
                    appViewModelGetCardUpdateListener = appViewModel.getCardUpdateListener();
                    // read appViewModel.getFoodList
                    appViewModelGetFoodList = appViewModel.getFoodList();
                    // read appViewModel.getCurrency
                    appViewModelGetCurrency = appViewModel.getCurrency();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel.updateFoodList(this.foodList, appViewModelGetFoodList, appViewModelGetCardUpdateListener, appViewModelGetCurrency);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): appViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}