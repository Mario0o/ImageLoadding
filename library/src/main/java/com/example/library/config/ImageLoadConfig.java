package com.example.library.config;

import com.example.library.R;
import com.example.library.Tools.UIUtils;
import com.example.library.cache.DiskCacheUtils;
import com.example.library.cache.MemoryCacheUtils;
import com.example.library.cache.NetCacheUtils;

/**
 * Created by orchid on 16-10-1.
 */

public class ImageLoadConfig {

    private int default_image_Id = R.drawable.ig_default_pic;
    private boolean useDiskCache = true;
    private long maxMemory = UIUtils.getMaxMemory();
    private int CONNECT_TIME = 3000;
    private int READ_TIME = 3000;
    private String LOCAL_PATH = UIUtils.getDefaultCachePath();
    private int inSampleSize = 1;



    public ImageLoadConfig setDefault_image_Id(int default_image_Id) {
        this.default_image_Id = default_image_Id;
        return this;
    }

    public ImageLoadConfig setUseDiskCache(boolean useDiskCache) {
        this.useDiskCache = useDiskCache;
        return this;
    }

    public ImageLoadConfig setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
        return this;
    }

    public ImageLoadConfig setCONNECT_TIME(int CONNECT_TIME) {
        this.CONNECT_TIME = CONNECT_TIME;
        return this;
    }

    public ImageLoadConfig setREAD_TIME(int READ_TIME) {
        this.READ_TIME = READ_TIME;
        return this;
    }

    public ImageLoadConfig setLOCAL_PATH(String LOCAL_PATH) {
        this.LOCAL_PATH = LOCAL_PATH;
        return this;
    }

    public ImageLoadConfig setInSampleSize(int inSampleSize) {
        this.inSampleSize = inSampleSize;
        return this;
    }

    public int getDefault_image_Id() {
        return default_image_Id;
    }

    public boolean isUseDiskCache() {
        return useDiskCache;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public int getCONNECT_TIME() {
        return CONNECT_TIME;
    }

    public int getREAD_TIME() {
        return READ_TIME;
    }

    public String getLOCAL_PATH() {
        return LOCAL_PATH;
    }

    public int getInSampleSize() {
        return inSampleSize;
    }
}
