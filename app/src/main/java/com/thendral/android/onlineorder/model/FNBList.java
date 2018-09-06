package com.thendral.android.onlineorder.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The type F and b list.
 */
public final class FNBList {
    @SerializedName("VistaFoodItemId")
    private String vistaFoodItemId;
    @SerializedName("Cinemaid")
    private String cinemaId;
    @SerializedName("ImageUrl")
    private String imageUrl;
    @SerializedName("PriceInCents")
    private String priceInCents;
    @SerializedName("TabName")
    private String tabName;
    @SerializedName("OtherExperience")
    private String otherExperience;
    @SerializedName("Name")
    private String name;
    @SerializedName("SubItemCount")
    private String subItemCount;
    @SerializedName("VegClass")
    private String vegClass;
    @SerializedName("ImgUrl")
    private String imgUrl;
    @SerializedName("ItemPrice")
    private String itemPrice;
    @SerializedName("subitems")
    private List<SubItem> subItems;
    @SerializedName("SevenStarExperience")
    private String sevenStarExperience;
    private SubItem selectedSubItem;


    /**
     * Gets selected sub item.
     *
     * @return the selected sub item
     */
    public SubItem getSelectedSubItem() {
        return selectedSubItem;
    }

    public void setSelectedSubItem(SubItem selectedSubItem) {
        this.selectedSubItem = selectedSubItem;
    }


    /**
     * Gets vista food item id.
     *
     * @return the vista food item id
     */
    public String getVistaFoodItemId() {
        return vistaFoodItemId;
    }

    /**
     * Gets cinema id.
     *
     * @return the cinema id
     */
    public String getCinemaId() {
        return cinemaId;
    }

    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageUrl() {
        return imageUrl;
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
     * Gets tab name.
     *
     * @return the tab name
     */
    public String getTabName() {
        return tabName;
    }

    /**
     * Gets other experience.
     *
     * @return the other experience
     */
    public String getOtherExperience() {
        return otherExperience;
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
     * Gets sub item count.
     *
     * @return the sub item count
     */
    public String getSubItemCount() {
        return subItemCount;
    }

    /**
     * Gets veg class.
     *
     * @return the veg class
     */
    public String getVegClass() {
        return vegClass;
    }

    /**
     * Gets img url.
     *
     * @return the img url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Sets item price.
     *
     * @param itemPrice the item price
     */
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Gets item price.
     *
     * @return the item price
     */
    public String getItemPrice() {
        return itemPrice;
    }

    /**
     * Gets sub items.
     *
     * @return the sub items
     */
    public List<SubItem> getSubItems() {
        return subItems;
    }

    /**
     * Gets seven star experience.
     *
     * @return the seven star experience
     */
    public String getSevenStarExperience() {
        return sevenStarExperience;
    }
}
