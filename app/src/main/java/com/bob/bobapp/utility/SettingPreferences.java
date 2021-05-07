package com.bob.bobapp.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingPreferences {

    public static final String PREFS_NAME = "bob_settings";

    public static void setSecretKey(Context context, String secretKey) {

        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME,  Context.MODE_PRIVATE).edit();

        editor.putString(Constants.PREF_SECRET_KEY, secretKey);

        editor.commit();
    }

    public static String getSecretKey(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        return prefs.getString(Constants.PREF_SECRET_KEY, "");
    }

    public static void setDeviceId(Context context, String secretKey) {

        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME,  Context.MODE_PRIVATE).edit();

        editor.putString(Constants.PREF_DEVICE_ID, secretKey);

        editor.commit();
    }

    public static String getDeviceId(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        return prefs.getString(Constants.PREF_DEVICE_ID, "");
    }

    public static void setRequestUniqueIdentifier(Context context, String uniqueId) {

        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME,  Context.MODE_PRIVATE).edit();

        editor.putString(Constants.PREF_UNIQUE_IDENTIFIER, uniqueId);

        editor.commit();
    }

    public static String getRequestUniqueIdentifier(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        return prefs.getString(Constants.PREF_UNIQUE_IDENTIFIER, "");
    }

    public static void setRiskProfile(Context context, String uniqueId) {

        SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME,  Context.MODE_PRIVATE).edit();

        editor.putString(Constants.PREF_RISK_PROFILE, uniqueId);

        editor.commit();
    }

    public static String getRiskProfile(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        return prefs.getString(Constants.PREF_RISK_PROFILE, "");
    }
}
