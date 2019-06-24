package com.example.hybss.mvpdemo.view.base;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    public static MyApplication app;
    public static MyApplication getInstance() {
        return app;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }


}
