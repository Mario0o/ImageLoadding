package com.example.library.cache;

import android.graphics.Bitmap;
import android.util.StringBuilderPrinter;

import com.example.library.config.ImageLoadConfig;

/**
 * Created by orchid on 16-10-1.
 */

public abstract class Imageload {

    public ImageLoadConfig config;
    public NetCacheUtils netCache;
    public   MemoryCacheUtils memoryCache;
    public DiskCacheUtils diskCache;

    public Imageload(ImageLoadConfig config,NetCacheUtils netCache,MemoryCacheUtils memoryCache,DiskCacheUtils diskCache) {
        this.config = config;
        this.netCache = netCache;
        this.memoryCache = memoryCache;
        this.diskCache = diskCache;
    }

    abstract Bitmap getBitmap(String url);
    abstract void setBitmap(String key,Bitmap value);

}
