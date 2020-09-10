package com.lenebf.demo.appdress;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.lenebf.android.app_dress.AppDress;
import com.lenebf.android.app_dress.DressUtil;
import com.lenebf.android.app_dress.NightColorFilter;
import com.lenebf.android.app_dress.color.EyeProtectionColor;
import com.lenebf.android.app_dress.color.GrayColor;
import com.lenebf.android.app_dress.color.NightColor;

public class SettingActivity extends AppCompatActivity implements NightColorFilter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.rb_gray: {
                        AppDress.tint(new GrayColor());
                        AppSetting.setDressColor(getApplicationContext(), AppSetting.COLOR_BLACK_WHITE);
                        break;
                    }
                    case R.id.rb_eye_protection: {
                        AppDress.tint(new EyeProtectionColor(0.3f));
                        AppSetting.setDressColor(getApplicationContext(), AppSetting.COLOR_EYE_PROTECTION);
                        break;
                    }
                    case R.id.rb_night_mode: {
                        AppDress.tint(new NightColor());
                        AppSetting.setDressColor(getApplicationContext(), AppSetting.COLOR_NIGHT_MODE);
                        break;
                    }
                    default: {
                        AppDress.tint(null);
                        AppSetting.setDressColor(getApplicationContext(), AppSetting.COLOR_NONE);
                        break;
                    }
                }
            }
        };
        RadioButton noneButton = findViewById(R.id.rb_none);
        noneButton.setOnClickListener(radioButtonClickListener);
        RadioButton grayModeButton = findViewById(R.id.rb_gray);
        grayModeButton.setOnClickListener(radioButtonClickListener);
        RadioButton eyeProtectModeButton = findViewById(R.id.rb_eye_protection);
        eyeProtectModeButton.setOnClickListener(radioButtonClickListener);
        RadioButton nightModeButton = findViewById(R.id.rb_night_mode);
        nightModeButton.setOnClickListener(radioButtonClickListener);
        int colorValue = AppSetting.getDressColor(getApplicationContext());
        if (AppSetting.COLOR_BLACK_WHITE == colorValue) {
            grayModeButton.setChecked(true);
        } else if (AppSetting.COLOR_EYE_PROTECTION == colorValue) {
            eyeProtectModeButton.setChecked(true);
        } else if (AppSetting.COLOR_NIGHT_MODE == colorValue) {
            nightModeButton.setChecked(true);
        } else {
            noneButton.setChecked(true);
        }
    }

    @Override
    public boolean excludeView(@NonNull View view) {
        return DressUtil.isStatusBrBackground(view) || DressUtil.isNavigationBarBackground(view);
    }
}