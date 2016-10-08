package com.example.library.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.library.Tools.UIUtils;
import com.example.library.config.ImageLoadConfig;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by orchid on 16-10-1.
 */

public class NetCacheUtils  extends Imageload {

    private AsyncTask<String,Integer,Bitmap> asyncTask;
    private Bitmap bitmap = null;

    public NetCacheUtils(ImageLoadConfig config,MemoryCacheUtils memoryCache,DiskCacheUtils diskCache) {
        super(config,null,memoryCache,diskCache);
    }

    public Bitmap disPlay(final ImageView imageView, final String url) {

        asyncTask = new AsyncTask<String, Integer, Bitmap>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);

            }

            @Override
            protected Bitmap doInBackground(String... params) {

                try {
                    URL url1 = new URL(params[0].toString());
                    HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(config.getREAD_TIME());
                    conn.setConnectTimeout(config.getCONNECT_TIME());
                    if(conn.getResponseCode() == 200){
                        InputStream is = conn.getInputStream();
                        BitmapFactory.Options  options = new BitmapFactory.Options();
                        options.inSampleSize = config.getInSampleSize();
                        options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                        bitmap = BitmapFactory.decodeStream(is,null,options);
                        conn.disconnect();
                        is.close();
                    }
                    return bitmap;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                imageView.setImageBitmap(bitmap);
                try{
                    memoryCache.setBitmap(url,bitmap);
                    diskCache.setBitmap(url,bitmap);

                }catch (NullPointerException e){
                    e.printStackTrace();
                }

            }
        }.execute(url);

        return bitmap;
    }


    @Override
    public Bitmap getBitmap(String url) {
        return null;
    }

    @Override
    public void setBitmap(String key, Bitmap value) {

    }

}
