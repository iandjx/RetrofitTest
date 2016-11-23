package com.feyzian.mohammad.retrofittest;

import android.app.Application;

import com.feyzian.mohammad.retrofittest.api.OAuthUtil;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // ensure the shared pref is initialized with the Global Context
        OAuthUtil.initSharedPref(this);
    }
}
