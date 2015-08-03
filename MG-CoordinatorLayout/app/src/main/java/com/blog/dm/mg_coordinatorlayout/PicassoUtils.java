package com.blog.dm.mg_coordinatorlayout;

import android.content.Context;

import com.squareup.picasso.Picasso;

/**
 * Created by Mac on 8/3/2015.
 */
public class PicassoUtils {
    private static Picasso instance;

    public static Picasso with(Context context) {
        if (instance == null) {
            instance = new Picasso.Builder(context.getApplicationContext())
                    .build();
        }
        return instance;
    }

    private PicassoUtils() {
        throw new AssertionError("No instances.");
    }
}
