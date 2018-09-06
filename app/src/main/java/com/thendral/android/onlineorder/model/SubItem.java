package com.thendral.android.onlineorder.model;

import com.google.gson.annotations.SerializedName;

/**
 * The type Sub items.
 */
public final class SubItem {

    @SerializedName("Name")
    private String name;
    @SerializedName("SubitemPrice")
    private String subItemPrice;
    @SerializedName("VistaSubFoodItemId")
    private String vistaSubFoodItemId;
    @SerializedName("PriceInCents")
    private String priceInCents;
    @SerializedName("VistaParentFoodItemId")
    private String vistaParentFoodItemId;
    private int subItemCount;

    /**
     * Gets sub item count.
     *
     * @return the sub item count
     */
    public int getSubItemCount() {
        return subItemCount;
    }

    /**
     * Sets sub item count.
     *
     * @param subItemCount the sub item count
     */
    public void setSubItemCount(int subItemCount) {
        this.subItemCount = subItemCount;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets sub item price.
     *
     * @return the sub item price
     */
    public String getSubItemPrice() {
        return subItemPrice;
    }

    /**
     * Gets vista sub food item id.
     *
     * @return the vista sub food item id
     */
    public String getVistaSubFoodItemId() {
        return vistaSubFoodItemId;
    }

    /**
     * Gets price in cents.
     *
     * @return the price in cents
     */
    public String getPriceInCents() {
        return priceInCents;
    }

    /**
     * Gets vista parent food item id.
     *
     * @return the vista parent food item id
     */
    public String getVistaParentFoodItemId() {
        return vistaParentFoodItemId;
    }
}
