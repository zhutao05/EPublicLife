package com.cimcitech.epubliclife.activity.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cimcitech.epubliclife.R;
import com.cimcitech.epubliclife.utils.StatusBarUtils;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        StatusBarUtils.setWindowActionAlpha(this);
    }
}
