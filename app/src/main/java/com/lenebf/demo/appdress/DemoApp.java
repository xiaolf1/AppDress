package com.lenebf.demo.appdress;

import android.app.Application;

import com.lenebf.android.app_dress.AppDress;

/**
 * @author lenebf@126.com
 * @since 2020/9/1
 */
public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDress.wear(this);
    }
}
