package com.lenebf.android.app_dress;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenebf@126.com
 * @since 2020/9/1
 */
public class AppDress {

    private static List<Activity> activeActivities = new ArrayList<>();
    private static DressColor dressColor;

    public static void wear(@NonNull Application app) {
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                activeActivities.add(activity);
                if (dressColor != null) {
                    dressColor.tint(activity);
                }
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                activeActivities.remove(activity);
            }
        });
    }

    public static void tint(@Nullable DressColor color) {
        DressColor oldColor = dressColor;
        dressColor = color;
        for (Activity activity : activeActivities) {
            if (oldColor != null) {
                oldColor.clear(activity);
            }
            Window window = activity.getWindow();
            if (window == null) {
                continue;
            }
            if (dressColor == null) {
                window.getDecorView().setLayerType(View.LAYER_TYPE_HARDWARE, null);
            } else {
                dressColor.tint(activity);
            }
        }
    }

    public static DressColor getColor() {
        return dressColor;
    }
}
