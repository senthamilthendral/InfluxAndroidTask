package com.thendral.android.influx.onlineorder.databinding;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class TestActivityBaseLayoutBinding extends ActivityBaseLayoutBinding {
    @NonNull
    public final android.widget.FrameLayout contentContainer;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    @NonNull
    public final android.widget.TextView toolbarTitle;

    // variables
    protected TestActivityBaseLayoutBinding(@Nullable android.databinding.DataBindingComponent bindingComponent, @Nullable android.view.View root_, int localFieldCount
            , android.widget.FrameLayout contentContainer1
            , android.support.v7.widget.Toolbar toolbar1
            , android.widget.TextView toolbarTitle1
    ) {
        super(bindingComponent, root_);
        this.contentContainer = contentContainer1;
        this.toolbar = toolbar1;
        this.toolbarTitle = toolbarTitle1;
    }

    //getters and abstract setters
    @NonNull
    public static TestActivityBaseLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static TestActivityBaseLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static TestActivityBaseLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static TestActivityBaseLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestActivityBaseLayoutBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.activity_base_layout, root, attachToRoot, bindingComponent);
    }

    @NonNull
    public static TestActivityBaseLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestActivityBaseLayoutBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.activity_base_layout, null, false, bindingComponent);
    }

    @NonNull
    public static TestActivityBaseLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return (TestActivityBaseLayoutBinding) bind(bindingComponent, view, com.thendral.android.influx.onlineorder.R.layout.activity_base_layout);
    }
}