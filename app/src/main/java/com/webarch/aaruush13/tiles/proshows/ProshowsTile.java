package com.webarch.aaruush13.tiles.proshows;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;
import com.webarch.aaruush13.tiles.ComingSoonPage;

public class ProshowsTile extends Tile {

    public ProshowsTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Proshows", 1, 1, Color.parseColor("#007DFF"), Color.parseColor("#00BEFF"), R.drawable.proshows_icon);

        addTileScreenPage("Proshows", ComingSoonPage.class, new String[]{});
    }

}