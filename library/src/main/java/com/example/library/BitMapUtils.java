package com.example.library;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.example.library.cache.DiskCacheUtils;
import com.example.library.cache.MemoryCacheUtils;
import com.example.library.cache.NetCacheUtils;
import com.example.library.config.ImageLoadConfig;

/**
 * Created by orchid on 16-10-1.
 */

public class BitMapUtils {

    private Bitmap bitmap;

    private ImageLoadConfig config;

    private NetCacheUtils netCache;
    private MemoryCacheUtils memoryCache;
    private DiskCacheUtils diskCache;

    public BitMapUtils() {
        this.config = new ImageLoadConfig();
        InstanceCache();
    }
    public BitMapUtils(ImageLoadConfig config) {
        this.config = config;
        InstanceCache();
    }

    public void BitMapUtils(NetCacheUtils netCache,MemoryCacheUtils memoryCache,DiskCacheUtils diskCache) {
        this.netCache = netCache;
        this.memoryCache = memoryCache;
        this.diskCache = diskCache;
    }

    public void InstanceCache(){
        memoryCache = new MemoryCacheUtils(config);
        diskCache = new DiskCacheUtils(config);
        netCache = new NetCacheUtils(config,memoryCache,diskCache);
    }

    public void disPlay(ImageView imageView, String url){
//        imageView.setImageResource(config.default_image_Id);

        if(this.memoryCache != null){
            bitmap = this.memoryCache.getBitmap(url);
            if(bitmap != null){
                Log.i("tag", "disPlay: "+"从内村获取");
                imageView.setImageBitmap(bitmap);
                return ;
            }
        }
        if(config.isUseDiskCache()&&this.diskCache != null){
            bitmap = this.diskCache.getBitmap(url,imageView);
            if(bitmap != null){
                Log.i("tag", "disPlay: "+"从硬盘获取");
                memoryCache.setBitmap(url,bitmap);
                imageView.setImageBitmap(bitmap);
                return;
            }
        }

        if(this.netCache != null){
            Log.i("tag", "disPlay: "+"从网络获取");
            this.netCache.disPlay(imageView,url);

        }
    }
}
