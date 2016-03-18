package com.webarch.aaruush13.tiles.gallery;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;
import com.webarch.aaruush13.tiles.ComingSoonPage;

public class GalleryTile extends Tile {

    public GalleryTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Gallery", 1, 1, Color.parseColor("#FF4678"), Color.parseColor("#FF6D91"), R.drawable.gallery_icon);

        addTileScreenPage("Gallery", ComingSoonPage.class, new String[]{});
    }

}