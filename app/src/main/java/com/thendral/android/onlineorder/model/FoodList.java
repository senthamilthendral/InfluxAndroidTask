package com.thendral.android.onlineorder.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Food list.
 */
public final class FoodList {
    @SerializedName("fnblist")
    private List<FNBList> fnbList;
    @SerializedName("TabName")
    private String tabName;

    /**
     * Gets fnb list.
     *
     * @return the fnb list
     */
    public ArrayList<FNBList> getFnbList() {
        return (ArrayList<FNBList>) fnbList;
    }

    /**
     * Gets tab name.
     *
     * @return the tab name
     */
    public String getTabName() {
        return tabName;
    }
}
