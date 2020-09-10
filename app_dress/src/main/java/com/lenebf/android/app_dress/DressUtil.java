package com.lenebf.android.app_dress;

import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * <a href="https://github.com/lenebf/AppDress/issues/1">https://github.com/lenebf/AppDress/issues/1</a>
 *
 * @author lenebf@126.com
 * @since 2020/9/10
 */
public class DressUtil {

    private DressUtil() throws IllegalAccessException {
        throw new IllegalAccessException("DressUtil is a util class.");
    }

    /**
     * @param view 需要被判断的View
     * @return true - 参数 view 是虚拟按键的背景View
     */
    public static boolean isNavigationBarBackground(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return view.getId() == android.R.id.navigationBarBackground;
        } else {
            return false;
        }
    }

    /**
     * @param view 需要被判断的View
     * @return true - 参数 view 是状态栏的背景View
     */
    public static boolean isStatusBrBackground(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return view.getId() == android.R.id.statusBarBackground;
        } else {
            return false;
        }
    }
}
