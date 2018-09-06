package com.thendral.android.influx.onlineorder.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public abstract class TestLayoutSubItemBinding extends LayoutSubItemBinding {
    @NonNull
    public final android.widget.RelativeLayout subItemLayout;
    @NonNull
    public final android.widget.TextView subItemName;
    // variables
    protected TestLayoutSubItemBinding(@Nullable android.databinding.DataBindingComponent bindingComponent, @Nullable android.view.View root_, int localFieldCount
        , android.widget.RelativeLayout subItemLayout1
        , android.widget.TextView subItemName1
    ) {
        super(bindingComponent, root_);
        this.subItemLayout = subItemLayout1;
        this.subItemName = subItemName1;
    }
    //getters and abstract setters
    @NonNull
    public static TestLayoutSubItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutSubItemBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutSubItemBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutSubItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestLayoutSubItemBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.layout_sub_item, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static TestLayoutSubItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestLayoutSubItemBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.layout_sub_item, null, false, bindingComponent);
    }
    @NonNull
    public static TestLayoutSubItemBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return (TestLayoutSubItemBinding)bind(bindingComponent, view, com.thendral.android.influx.onlineorder.R.layout.layout_sub_item);
    }
}