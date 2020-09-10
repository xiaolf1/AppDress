package com.lenebf.android.app_dress.color;

import android.app.Activity;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;

import com.lenebf.android.app_dress.DressColor;
import com.lenebf.android.app_dress.NightColorFilter;
import com.lenebf.android.app_dress.internal.ObservableNightColorFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 夜间模式颜色转换，待完善，不建议使用
 * </p>
 *
 * @author lenebf@126.com
 * @since 2020/9/1
 */
public class NightColor extends DressColor {

    private static List<ObservableNightColorFilter> filters = new ArrayList<>();

    public static void revert(@NonNull View view) {
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix(new float[]{
                -1, 0, 0, 0, 255,
                0, -1, 0, 0, 255,
                0, 0, -1, 0, 255,
                0, 0, 0, 1, 0
        });
        paint.setColorFilter(new ColorMatrixColorFilter(cm));
        view.setLayerType(View.LAYER_TYPE_HARDWARE, paint);
    }

    @Override
    public void tint(@NonNull Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        View view = window.getDecorView();
        Paint rootPaint = new Paint();
        ColorMatrix cm = new ColorMatrix(new float[]{
                -1, 0, 0, 0, 255,
                0, -1, 0, 0, 255,
                0, 0, -1, 0, 255,
                0, 0, 0, 1, 0
        });
        rootPaint.setColorFilter(new ColorMatrixColorFilter(cm));
        view.setLayerType(View.LAYER_TYPE_HARDWARE, rootPaint);
        if (view instanceof ViewGroup && activity instanceof NightColorFilter) {
            filters.add(new ObservableNightColorFilter((NightColorFilter) activity,
                    (ViewGroup) view));
        }
    }

    @Override
    public void clear(@NonNull Activity activity) {
        for (ObservableNightColorFilter filter : filters) {
            if (filter != null && filter.match(activity)) {
                filter.destroy(activity);
            }
        }
    }
}
