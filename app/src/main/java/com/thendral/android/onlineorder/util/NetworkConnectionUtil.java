package com.thendral.android.onlineorder.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Utility class to handle net work check
 */
public final class NetworkConnectionUtil {

    /**
     * To check Internet Connectivity on Device.
     * This method check the device connectivity and return the status
     *
     * @param ctx Application Context
     * @return the status of device network connectivity
     */
    public static boolean isInternetAvailable(Context ctx) {
        boolean lRetVal = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo nInfo = cm.getActiveNetworkInfo();
                if (null != nInfo) {
                    lRetVal = nInfo.isConnectedOrConnecting();
                }
            }
        } catch (Exception e) {
            return false;
        }

        return lRetVal;
    }

}
