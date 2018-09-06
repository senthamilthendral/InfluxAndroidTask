package com.thendral.android.influx.onlineorder.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public abstract class TestFragmentHomeBinding extends ViewDataBinding {
    @NonNull
    public final android.widget.RelativeLayout bottomSheet;
    @NonNull
    public final android.support.v7.widget.RecyclerView cartList;
    @NonNull
    public final android.widget.RelativeLayout expandedLayout;
    @NonNull
    public final android.widget.ImageView imageArrodw;
    @NonNull
    public final android.widget.ImageView imageArrow;
    @NonNull
    public final android.support.v4.view.ViewPager pager;
    @NonNull
    public final android.widget.TextView payText;
    @NonNull
    public final android.widget.TextView summaryText;
    @NonNull
    public final android.support.design.widget.TabLayout tabLayout;
    @NonNull
    public final android.widget.TextView totalAmount;
    @NonNull
    public final android.widget.RelativeLayout totalBillLayout;
    // variables
    protected TestFragmentHomeBinding(@Nullable android.databinding.DataBindingComponent bindingComponent, @Nullable android.view.View root_, int localFieldCount
        , android.widget.RelativeLayout bottomSheet1
        , android.support.v7.widget.RecyclerView cartList1
        , android.widget.RelativeLayout expandedLayout1
        , android.widget.ImageView imageArrodw1
        , android.widget.ImageView imageArrow1
        , android.support.v4.view.ViewPager pager1
        , android.widget.TextView payText1
        , android.widget.TextView summaryText1
        , android.support.design.widget.TabLayout tabLayout1
        , android.widget.TextView totalAmount1
        , android.widget.RelativeLayout totalBillLayout1
    ) {
        super(bindingComponent, root_, localFieldCount);
        this.bottomSheet = bottomSheet1;
        this.cartList = cartList1;
        this.expandedLayout = expandedLayout1;
        this.imageArrodw = imageArrodw1;
        this.imageArrow = imageArrow1;
        this.pager = pager1;
        this.payText = payText1;
        this.summaryText = summaryText1;
        this.tabLayout = tabLayout1;
        this.totalAmount = totalAmount1;
        this.totalBillLayout = totalBillLayout1;
    }
    //getters and abstract setters
    @NonNull
    public static TestFragmentHomeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestFragmentHomeBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestFragmentHomeBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static TestFragmentHomeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestFragmentHomeBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.fragment_home, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static TestFragmentHomeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return DataBindingUtil.<TestFragmentHomeBinding>inflate(inflater, com.thendral.android.influx.onlineorder.R.layout.fragment_home, null, false, bindingComponent);
    }
    @NonNull
    public static TestFragmentHomeBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return (TestFragmentHomeBinding)bind(bindingComponent, view, com.thendral.android.influx.onlineorder.R.layout.fragment_home);
    }
}