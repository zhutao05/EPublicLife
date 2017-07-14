package com.cimcitech.epubliclife;

import android.app.Application;

import com.cimcitech.epubliclife.utils.Config;

/**
 * Created by cimcitech on 2017/7/14.
 */

public class ApkApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Config.CONTEXT = getApplicationContext();
    }
}
