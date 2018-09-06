package com.thendral.android.onlineorder.model;

import com.google.gson.annotations.SerializedName;

/**
 * The type Status.
 */
public final class Status {
    @SerializedName("description")
    private String description;
    @SerializedName("id")
    private String id;

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }
}
