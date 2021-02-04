package com.app.developframework.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private ToastUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void showToast(Context context, String toastStr) {
        if (context == null) return;
        Toast.makeText(context, toastStr, Toast.LENGTH_SHORT).show();
    }
}
