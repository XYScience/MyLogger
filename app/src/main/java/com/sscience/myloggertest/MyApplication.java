package com.sscience.myloggertest;

import android.app.Application;

import com.sscience.log.Logger;

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2017/6/7
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(BuildConfig.DEBUG);
    }
}
