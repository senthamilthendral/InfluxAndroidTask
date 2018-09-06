package com.thendral.android.influx.onlineorder.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public abstract class TestAdapterFoodListBinding extends AdapterFoodListBinding {
    @NonNull
    public final android.support.v7.widget.RecyclerView foodList;
    // variables
    protected com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel mAppViewModel;
    protected TestAdapterFoodListBinding(@Nullable android.databinding.DataBindingComponent bindingComponent, @Nullable android.view.View root_, int localFieldCount
        , android.support.v7.widget.RecyclerView foodList1
    ) {
        super(bindingComponent, root_);
        this.foodList = foodList1;
    }
    //getters and abstract setters
    public abstract void setAppViewModel(@Nullable com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel AppViewModel);
    @Nullable
    public com.thendral.android.onlineorder.view.viewmodel.FoodListViewModel getAppViewModel() {
        return mAppViewModel;
    }
    @NonNull
    public static TestAdapterFoodListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestAdapterFoodListBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestAdapterFoodListBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestAdapterFoodListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestAdapterFoodListBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.adapter_food_list, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static TestAdapterFoodListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestAdapterFoodListBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.adapter_food_list, null, false, bindingComponent);
    }
    @NonNull
    public static TestAdapterFoodListBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return (TestAdapterFoodListBinding)bind(bindingComponent, view, com.thendral.android.influx.onlineorder.R.layout.adapter_food_list);
    }
}