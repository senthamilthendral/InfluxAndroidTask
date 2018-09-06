package com.thendral.android.onlineorder.model;

/**
 * The type Cart item.
 */
public final class CartItem {
    private int foodID;
    private String menuName;
    private String prize;
    private int count;

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Instantiates a new Cart item.
     *
     * @param foodID   the food id
     * @param menuName the menu name
     * @param prize    the prize
     */
    public CartItem(int foodID, String menuName, String prize) {
        this.foodID = foodID;
        this.menuName = menuName;
        this.prize = prize;
    }


    /**
     * Gets food id.
     *
     * @return the food id
     */
    public int getFoodID() {
        return foodID;
    }

    /**
     * Gets menu name.
     *
     * @return the menu name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Gets prize.
     *
     * @return the prize
     */
    public String getPrize() {
        return prize;
    }

}
