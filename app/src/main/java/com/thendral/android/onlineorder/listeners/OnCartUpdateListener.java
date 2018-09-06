package com.thendral.android.onlineorder.listeners;

import com.thendral.android.onlineorder.model.CartItem;

/**
 * The interface used to update the Cart List that added.
 */
public interface OnCartUpdateListener {

    /**
     * Method be called when item is added to the cart.
     *
     * @param cartItem the cart item
     */
    void onMenuAdded(CartItem cartItem, String currency);

    /**
     * Method be called when item is removed from the cart
     *
     * @param menuID food ID
     */
    void onMenuRemoved(int menuID, String currency);
}
