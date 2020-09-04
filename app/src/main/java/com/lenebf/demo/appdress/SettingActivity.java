package com.lenebf.demo.appdress;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.lenebf.android.app_dress.AppDress;
import com.lenebf.android.app_dress.DressColor;
import com.lenebf.android.app_dress.EyeProtectionColor;
import com.lenebf.android.app_dress.GrayColor;
import com.lenebf.android.app_dress.NightColor;

public class SettingActivity extends AppCompatActivity {

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
                        break;
                    }
                    case R.id.rb_eye_protection: {
                        AppDress.tint(new EyeProtectionColor(0.3f));
                        break;
                    }
                    case R.id.rb_night_mode: {
                        AppDress.tint(new NightColor());
                        break;
                    }
                    default: {
                        AppDress.tint(null);
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
        DressColor color = AppDress.getColor();
        if (color instanceof GrayColor) {
            grayModeButton.setChecked(true);
        } else if (color instanceof EyeProtectionColor) {
            eyeProtectModeButton.setChecked(true);
        } else if (color instanceof NightColor) {
            nightModeButton.setChecked(true);
        } else {
            noneButton.setChecked(true);
        }
    }
}