package com.hmetao.ticketunion.utils;


import android.text.TextUtils;
import android.util.Log;


public class LogUtils {

    private static final int LEVEL = LogLevelEnum.D.ordinal();

    private static final String TAG = "HMETAO";

    public static void e(String message) {
        if (LEVEL <= LogLevelEnum.E.ordinal() && !TextUtils.isEmpty(message)) {
            Log.e(TAG, message);
        }
    }

    public static void w(String message) {
        if (LEVEL <= LogLevelEnum.W.ordinal() && !TextUtils.isEmpty(message)) {
            Log.w(TAG, message);
        }
    }

    public static void i(String message) {
        if (LEVEL <= LogLevelEnum.I.ordinal() && !TextUtils.isEmpty(message)) {
            Log.i(TAG, message);
        }
    }

    public static void d(String message) {
        if (LEVEL <= LogLevelEnum.D.ordinal() && !TextUtils.isEmpty(message)) {
            Log.d(TAG, message);
        }
    }

}

enum LogLevelEnum {
    D,
    I,
    W,
    E

}