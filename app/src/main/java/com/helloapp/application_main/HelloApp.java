package com.helloapp.application_main;

import android.app.Application;

import androidx.multidex.MultiDex;

import com.facebook.drawee.backends.pipeline.Fresco;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class HelloApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        MultiDex.install(this);
    }
}
