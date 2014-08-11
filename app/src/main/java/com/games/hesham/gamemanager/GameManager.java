package com.games.hesham.gamemanager;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.games.hesham.gamemanager.object.GameObject;
import com.games.hesham.gamemanager.object.ObjectGenerator;

import java.util.ArrayList;

/**
 * Created by Hesham on 8/10/2014.
 */
public class GameManager extends Application {

    private static ArrayList<GameObject> gameObjects = null;

    public  static RequestQueue requestQueue;
    public  static ImageLoader imageLoader;
    public void onCreate() {
        gameObjects = ObjectGenerator.generateGameObject();
        requestQueue = Volley.newRequestQueue(this);
        imageLoader = new ImageLoader(requestQueue, new BitmapCache(20));
    }


         public static ArrayList<GameObject> getGameObjects() {
        return gameObjects;
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

