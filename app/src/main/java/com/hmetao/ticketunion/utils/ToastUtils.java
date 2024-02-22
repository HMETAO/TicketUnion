package com.hmetao.ticketunion.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private static Toast toast;

    public static void showToast(Context context, String description) {
        if (toast == null) {
            toast = Toast.makeText(context, description, Toast.LENGTH_SHORT);
        } else {
            toast.setText(description);
        }
        toast.show();
    }
}
