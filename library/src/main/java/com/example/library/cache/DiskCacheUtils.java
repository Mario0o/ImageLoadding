package com.example.library.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.library.Tools.MD5Encoder;
import com.example.library.Tools.UIUtils;
import com.example.library.config.ImageLoadConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import static android.R.attr.bitmap;
import static android.R.attr.finishOnCloseSystemDialogs;
import static android.R.attr.max;
import static android.R.attr.smallIcon;

/**
 * Created by orchid on 16-10-1.
 */

public class DiskCacheUtils extends Imageload {

    public DiskCacheUtils(ImageLoadConfig config) {
        super(config,null,null,null);
    }

    public Bitmap getBitmap(String url, ImageView imageView) {
        try {
            File cacheFile = new File(config.getLOCAL_PATH(), MD5Encoder.encode(url));

            if (cacheFile.exists()) {
                InputStream is = new FileInputStream(cacheFile);
                BitmapFactory.Options ops = new BitmapFactory.Options();

                Bitmap bitmap = BitmapFactory.decodeStream(is,null,ops);
                return bitmap;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    Bitmap getBitmap(String url) {
        return null;
    }

    @Override
    public void setBitmap(String key, Bitmap value) {

        File dir = new File(config.getLOCAL_PATH());
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();// 创建文件夹
        }

        try {
            String fileName = MD5Encoder.encode(key);

            File cacheFile = new File(dir, fileName);

            value.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(
                    cacheFile));// 参1:图片格式;参2:压缩比例0-100; 参3:输出流
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
