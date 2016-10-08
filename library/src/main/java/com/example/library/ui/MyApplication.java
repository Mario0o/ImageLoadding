package com.example.library.ui;

import android.app.Application;
import android.content.Context;

/**
 * Created by orchid on 16-10-8.
 */

public class MyApplication extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
