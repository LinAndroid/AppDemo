package com.app.developframework.utils;

import android.util.Log;


public class LogUtils {
    private static final String LOG_TAG = "hlj";
    private static final boolean isDebug = true;

    private LogUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void logE(String msg) {
        if (isDebug) {
            Log.e(LOG_TAG, msg);
        }
    }

    public static void logE(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

}
