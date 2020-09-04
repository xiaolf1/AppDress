package com.lenebf.android.app_dress;

import android.app.Activity;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

/**
 * <p>
 * 灰阶（黑白）模式颜色转换
 * </p>
 *
 * @author lenebf@126.com
 * @since 2020/9/1
 */
public class GrayColor extends DressColor {

    @Override
    public void tint(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        View view = window.getDecorView();
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0f);
        paint.setColorFilter(new ColorMatrixColorFilter(cm));
        view.setLayerType(View.LAYER_TYPE_HARDWARE, paint);
    }

    @Override
    public void clear(@NonNull Activity activity) {

    }
}
