package com.thendral.android.onlineorder.listeners;

import com.thendral.android.onlineorder.model.SubItem;

/**
 * The interface used to give the call back when item selection
 * is changed.
 */
public interface OnMenuOptionSelectListener {
    /**
     * Method be called to notify the caller that sub Item selection changed
     *
     * @param subMenuPosition the sub menu position
     * @param subItem         the sub item
     */
    void onMenuSelected(int subMenuPosition, SubItem subItem);
}
