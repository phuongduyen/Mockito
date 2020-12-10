package com.example.mockitofirst.MyManager;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import static androidx.core.content.ContextCompat.getSystemService;

public class URLManager {

    public URLManager() {
    }

    public String getHost(String url){
        Uri uri = Uri.parse(url);
        String host = uri.getHost();
        if(!TextUtils.isEmpty(host)){
            return host;
        }
        return null;
    }

    public Rect getRect(Context context){
//        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
//        int pxWidth = displayMetrics.widthPixels;
//        int pxHeight = displayMetrics.heightPixels;
        int pxWidth = 1080;
        int pxHeight = 3600;

        Rect rect = new Rect(0, 0, pxWidth, pxHeight);
        return rect;
    }

    public float getH(Context context){
//        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
//        int pxWidth = displayMetrics.widthPixels;
//        int pxHeight = displayMetrics.heightPixels;
        int pxWidth = 1080;
        int pxHeight = 3600;

        Rect rect = new Rect(0, 0, pxWidth, pxHeight);
        return rect.height();
    }

}
