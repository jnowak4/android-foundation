/*
 * Copyright (c) 2017. Core Logic
 */

package com.corelogic.foundation.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

/**
 * Created on 5/1/17.
 */

public class ConnectivityUtil {

    private final Context context;

    @Inject
    public ConnectivityUtil(final Context context) {
        this.context = context;
    }


    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    public boolean isThereInternetConnection()
    {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
