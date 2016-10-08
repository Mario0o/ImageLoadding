package com.example.library.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.example.library.config.ImageLoadConfig;

import java.lang.ref.SoftReference;

/**
 * Created by orchid on 16-10-1.
 */

public class MemoryCacheUtils extends Imageload {

    private LruCache<String,Bitmap> lruCache;

    public MemoryCacheUtils(ImageLoadConfig config) {
        super(config,null, null, null);

        lruCache = new LruCache<String, Bitmap>((int) config.getMaxMemory()){
            @Override
            protected int sizeOf(String key, Bitmap value) {

                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {

            return lruCache.get(url);
    }

    @Override
    public void setBitmap(String key, Bitmap value) {
        lruCache.put(key,value);
    }
}
