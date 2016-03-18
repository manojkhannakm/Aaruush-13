package com.webarch.aaruush13.components;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

public class TileScreenPageAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] tileScreenPageTitles;
    private String[] tileScreenPageClassNames;
    private WeakReference[] tileScreenPageReferences;

    public TileScreenPageAdapter(Context context, FragmentManager fm, String[] tileScreenPageTitles, String[] tileScreenPageClassNames) {
        super(fm);

        this.context = context;
        this.tileScreenPageTitles = tileScreenPageTitles;
        this.tileScreenPageClassNames = tileScreenPageClassNames;

        tileScreenPageReferences = new WeakReference[tileScreenPageTitles.length];
    }

    @Override
    public Fragment getItem(int position) {
        return Fragment.instantiate(context, tileScreenPageClassNames[position]);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TileScreenPage tileScreenPage = (TileScreenPage) super.instantiateItem(container, position);
        tileScreenPage.setTileScreenPageTitle(tileScreenPageTitles[position]);
        tileScreenPageReferences[position] = new WeakReference<TileScreenPage>(tileScreenPage);
        return tileScreenPage;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        tileScreenPageReferences[position].clear();
        tileScreenPageReferences[position] = null;

        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return tileScreenPageTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tileScreenPageTitles[position];
    }

    public TileScreenPage[] getTileScreenPages() {
        TileScreenPage[] tileScreenPages = new TileScreenPage[tileScreenPageReferences.length];
        for (int i = 0; i < tileScreenPages.length; i++) {
            if (tileScreenPageReferences[i] != null) {
                tileScreenPages[i] = (TileScreenPage) tileScreenPageReferences[i].get();
            }
        }
        return tileScreenPages;
    }

}