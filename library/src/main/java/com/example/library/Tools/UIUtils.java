package com.example.library.Tools;

import android.content.Context;

import com.example.library.ui.MyApplication;

/**
 * Created by orchid on 16-10-8.
 */

public class UIUtils {

    public static Context getContext(){
        return MyApplication.getContext();
    }
    public static String getDefaultCachePath(){
        return getContext().getCacheDir().getPath();
    }
    public static long getMaxMemory(){
        return Runtime.getRuntime().maxMemory()/8;
    }
    public static int getScreenWidth(){
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }
    public static int getScreenHeight(){
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }
}
