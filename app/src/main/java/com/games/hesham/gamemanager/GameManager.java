package com.games.hesham.gamemanager;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Hesham on 8/10/2014.
 */
public class GameManager extends Application {

    public  static RequestQueue requestQueue;
    public  static ImageLoader imageLoader;
    public void onCreate() {
        requestQueue = Volley.newRequestQueue(this);
        imageLoader = new ImageLoader(requestQueue, new BitmapCache(5));
    }
    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }
    public static ImageLoader getImageLoader(){
        return imageLoader;
    }
    private class BitmapCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
        public BitmapCache(int maxSize) {
            super(maxSize);
        }

        @Override
        public Bitmap getBitmap(String url) {
            return (Bitmap)get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            put(url, bitmap);
        }
    }
}
