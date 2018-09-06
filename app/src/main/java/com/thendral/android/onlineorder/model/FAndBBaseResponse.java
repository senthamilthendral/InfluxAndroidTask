package com.thendral.android.onlineorder.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * The type F and b base response.
 */
public final class FAndBBaseResponse {

    @SerializedName("FoodList")
    private List<FoodList> foodList;
    @SerializedName("status")
    private Status status;
    @SerializedName("Currency")
    private String currency;

    /**
     * Gets food list.
     *
     * @return the food list
     */
    public ArrayList<FoodList> getFoodList() {
        return (ArrayList<FoodList>) foodList;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

}
