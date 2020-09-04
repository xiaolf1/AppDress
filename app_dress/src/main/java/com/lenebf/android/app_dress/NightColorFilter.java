package com.lenebf.android.app_dress;

import android.view.View;

import androidx.annotation.NonNull;

/**
 * @author lenebf@126.com
 * @since 2020/9/5
 */
public interface NightColorFilter {

    /**
     * 是否对该View逆转夜间模式
     *
     * @param view 需要判定的View
     * @return true-逆转该View
     */
    boolean excludeView(@NonNull View view);
}
