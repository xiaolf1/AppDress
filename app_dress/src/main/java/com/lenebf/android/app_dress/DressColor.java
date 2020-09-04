package com.lenebf.android.app_dress;

import android.app.Activity;

import androidx.annotation.NonNull;

/**
 * @author lenebf@126.com
 * @since 2020/9/1
 */
public abstract class DressColor {
    /**
     * 给裙子着色
     *
     * @param activity 被着色对象
     */
    public abstract void tint(@NonNull Activity activity);

    /**
     * 给裙子擦除
     *
     * @param activity 被擦除对象
     */
    public abstract void clear(@NonNull Activity activity);
}
