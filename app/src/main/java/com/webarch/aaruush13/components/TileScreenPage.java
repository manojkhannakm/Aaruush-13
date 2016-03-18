package com.webarch.aaruush13.components;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

import com.webarch.aaruush13.Aaruush13;

import java.util.HashMap;

public abstract class TileScreenPage extends Fragment {

    protected Aaruush13 aaruush13;
    private boolean isInForeground = false, isBackKeyEnabled = false;
    private String tileScreenPageTitle;
    private Runnable onOpenRunnable;
    private ScrollView searchScrollView;
    private HashMap<String, Object> searchTagsMap = new HashMap<String, Object>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aaruush13 = (Aaruush13) getActivity().getApplication();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setPadding(aaruush13.border2, aaruush13.border2, aaruush13.border2, aaruush13.border2);
    }

    @Override
    public void onResume() {
        super.onResume();

        getView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    //noinspection deprecation
                    getView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                if (onOpenRunnable != null) {
                    onOpenRunnable.run();
                    onOpenRunnable = null;
                }
            }

        });

        isInForeground = true;
    }

    @Override
    public void onPause() {
        isInForeground = false;

        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        aaruush13 = null;
        onOpenRunnable = null;
    }

    public void onOpen(boolean quickOpen) {
    }

    public void onSearch(String searchResult) {
        Object object = searchTagsMap.get(searchResult);
        if (object instanceof View) {
            View childView = (View) object;
            int y = -aaruush13.border2;
            while (childView != searchScrollView) {
                y += childView.getTop();
                try {
                    childView = (View) childView.getParent();
                } catch (ClassCastException e) {
                    break;
                }
            }
            searchScrollView.smoothScrollTo(0, y);
        } else if (object instanceof Integer) {
            searchScrollView.smoothScrollTo(0, searchScrollView.getChildAt(0).getHeight() * ((Integer) object) / 100);
        }
    }

    public void onBackPressed() {
    }

    protected Object getSearchTagObject(String searchTag) {
        return searchTagsMap.get(searchTag);
    }

    protected void addSearchTag(String searchTag, Object object) {
        searchTagsMap.put(searchTag, object);
    }

    protected void setSearchScrollView(ScrollView searchScrollView) {
        this.searchScrollView = searchScrollView;
    }

    public boolean isBackKeyEnabled() {
        return isBackKeyEnabled;
    }

    protected void setBackKeyEnabled(boolean backKeyEnabled) {
        isBackKeyEnabled = backKeyEnabled;
    }

    public void setOnOpenRunnable(Runnable onOpenRunnable) {
        if (!isInForeground) {
            this.onOpenRunnable = onOpenRunnable;
        } else {
            onOpenRunnable.run();
        }
    }

    public String getTileScreenPageTitle() {
        return tileScreenPageTitle;
    }

    public void setTileScreenPageTitle(String tileScreenPageTitle) {
        this.tileScreenPageTitle = tileScreenPageTitle;
    }

}