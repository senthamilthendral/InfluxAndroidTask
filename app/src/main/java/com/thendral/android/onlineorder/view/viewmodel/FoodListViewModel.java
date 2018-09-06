package com.thendral.android.onlineorder.view.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.thendral.android.onlineorder.listeners.OnCartUpdateListener;
import com.thendral.android.onlineorder.model.FNBList;
import com.thendral.android.onlineorder.model.FoodList;
import com.thendral.android.onlineorder.view.adapter.FoodListAdapter;

import java.util.Collections;
import java.util.List;

/**
 * The Food list view model responsible for acting bridge between Food ListView and model. This class
 * extends the {@link BaseObservable} to notify the view on its change.
 */
public final class FoodListViewModel extends BaseObservable {

    private FoodList mFoodList;
    private String mCurrency;
    private OnCartUpdateListener mOnCartUpdateListener;

    /**
     * Instantiates a new Food list view model.
     *
     * @param pCurrency             the p currency
     * @param foodList              the food list
     * @param pOnCartUpdateListener the p on cart update listener
     */
    public FoodListViewModel(String pCurrency, FoodList foodList, OnCartUpdateListener pOnCartUpdateListener) {
        this.mFoodList = foodList;
        this.mCurrency = pCurrency;
        this.mOnCartUpdateListener = pOnCartUpdateListener;
    }

    /**
     * Update food list.
     *
     * @param recyclerView         the recycler view
     * @param foodList             the food list
     * @param onCartUpdateListener the on cart update listener
     * @param pCurrency            the p currency
     */
    @BindingAdapter({"updateFoodList", "onCartUpdate", "currencyVal"})
    public static void updateFoodList(RecyclerView recyclerView, List<FNBList> foodList, OnCartUpdateListener onCartUpdateListener, String pCurrency) {
        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 1));
        }
        FoodListAdapter appListAdapter = new FoodListAdapter(pCurrency, foodList, onCartUpdateListener);
        recyclerView.setAdapter(appListAdapter);
    }

    /**
     * Gets card update listener.
     *
     * @return the card update listener
     */
    public OnCartUpdateListener getCardUpdateListener() {
        return mOnCartUpdateListener;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return mCurrency;
    }

    /**
     * Gets food list.
     *
     * @return the food list
     */
    public List<FNBList> getFoodList() {
        if (mFoodList == null) {
            return Collections.emptyList();
        }
        return mFoodList.getFnbList();
    }
}
