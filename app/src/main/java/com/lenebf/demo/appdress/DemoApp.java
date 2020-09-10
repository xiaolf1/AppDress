package com.lenebf.demo.appdress;

import android.app.Application;

import com.lenebf.android.app_dress.AppDress;
import com.lenebf.android.app_dress.color.EyeProtectionColor;
import com.lenebf.android.app_dress.color.GrayColor;
import com.lenebf.android.app_dress.color.NightColor;

/**
 * @author lenebf@126.com
 * @since 2020/9/1
 */
public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDress.wear(this);
        // recovery saved color
        int color = AppSetting.getDressColor(this);
        if (AppSetting.COLOR_BLACK_WHITE == color) {
            AppDress.tint(new GrayColor());
        } else if (AppSetting.COLOR_EYE_PROTECTION == color) {
            AppDress.tint(new EyeProtectionColor(0.3f));
        } else if (AppSetting.COLOR_NIGHT_MODE == color) {
            AppDress.tint(new NightColor());
        } else {
            AppDress.tint(null);
        }
    }
}
