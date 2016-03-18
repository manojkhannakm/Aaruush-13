package com.webarch.aaruush13;

import android.app.Application;
import android.content.res.Resources;

import com.webarch.aaruush13.activities.MainActivity;
import com.webarch.aaruush13.activities.TileScreenActivity;

public class Aaruush13 extends Application {

    //TODO: Check all post & viewTreeObserver if possible replace with AndroidUtils
    //TODO: Replace all random with RandomUtils
    //TODO: Check all WeakRef

    public int border1, border2, border3;
    public float text1, text2, text3;
    public MainActivity mainActivity;
    public TileScreenActivity tileScreenActivity;

    @Override
    public void onCreate() {
        super.onCreate();

        Resources resources = getResources();
        border1 = resources.getDimensionPixelSize(R.dimen.border_1);
        border2 = resources.getDimensionPixelSize(R.dimen.border_2);
        border3 = resources.getDimensionPixelSize(R.dimen.border_3);
        text1 = resources.getDimensionPixelSize(R.dimen.text_1);
        text2 = resources.getDimensionPixelSize(R.dimen.text_2);
        text3 = resources.getDimensionPixelSize(R.dimen.text_3);
    }

}