package com.helloapp.application_main;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class HelloApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
