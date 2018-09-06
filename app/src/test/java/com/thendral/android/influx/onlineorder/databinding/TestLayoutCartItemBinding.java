package com.thendral.android.influx.onlineorder.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public abstract class TestLayoutCartItemBinding extends LayoutCartItemBinding {
    @NonNull
    public final android.widget.LinearLayout cartItemLayout;
    @NonNull
    public final android.widget.TextView cartItemName;
    @NonNull
    public final android.widget.TextView itemSum;
    // variables
    protected TestLayoutCartItemBinding(@Nullable android.databinding.DataBindingComponent bindingComponent, @Nullable android.view.View root_, int localFieldCount
        , android.widget.LinearLayout cartItemLayout1
        , android.widget.TextView cartItemName1
        , android.widget.TextView itemSum1
    ) {
        super(bindingComponent, root_);
        this.cartItemLayout = cartItemLayout1;
        this.cartItemName = cartItemName1;
        this.itemSum = itemSum1;
    }
    //getters and abstract setters
    @NonNull
    public static TestLayoutCartItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutCartItemBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutCartItemBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestLayoutCartItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestLayoutCartItemBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.layout_cart_item, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static TestLayoutCartItemBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestLayoutCartItemBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.layout_cart_item, null, false, bindingComponent);
    }
    @NonNull
    public static TestLayoutCartItemBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return (TestLayoutCartItemBinding)bind(bindingComponent, view, com.thendral.android.influx.onlineorder.R.layout.layout_cart_item);
    }
}