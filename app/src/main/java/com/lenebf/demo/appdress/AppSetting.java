package com.lenebf.demo.appdress;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author lenebf@126.com
 * @since 2020/9/10
 */
public class AppSetting {

    public static final int COLOR_NONE = 0;
    public static final int COLOR_BLACK_WHITE = 1;
    public static final int COLOR_EYE_PROTECTION = 2;
    public static final int COLOR_NIGHT_MODE = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({COLOR_NONE, COLOR_BLACK_WHITE, COLOR_EYE_PROTECTION, COLOR_NIGHT_MODE})
    @interface DressColorValue {

    }

    private static final String PREF_NAME = "setting";
    private static final String KEY_DRESS_COLOR = "color";

    private AppSetting() {

    }

    @DressColorValue
    public static int getDressColor(@NonNull Context context) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getInt(KEY_DRESS_COLOR, COLOR_NONE);
    }

    public static void setDressColor(@NonNull Context context, @DressColorValue int color) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(KEY_DRESS_COLOR, color).apply();
    }
}
