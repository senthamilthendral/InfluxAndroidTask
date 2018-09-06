package com.thendral.android.onlineorder.util;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.thendral.android.onlineorder.model.FAndBBaseResponse;

import java.io.IOException;
import java.io.InputStream;

/**
 * The type Online order service util.
 */
public final class OnlineOrderServiceUtil {

    /**
     * Gets food data from local.
     *
     * @param context the context
     * @return the food data from local
     */
    public static FAndBBaseResponse getFoodDataFromLocal(final Context context) {
        FAndBBaseResponse fAndBBaseResponse = null;
        String assetsConfig = getDataFromLocalAsset(context);
        if (!TextUtils.isEmpty(assetsConfig)) {
            fAndBBaseResponse = new Gson().fromJson(assetsConfig, FAndBBaseResponse.class);
        }
        return fAndBBaseResponse;
    }

    private static String getDataFromLocalAsset(final Context context) {
        String json;
        InputStream is = null;
        try {
            is = context.getAssets().open("onlinorder_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);

            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }
}
