package com.webarch.aaruush13.tiles.newtoaaruush;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;
import com.webarch.aaruush13.tiles.ComingSoonPage;

public class NewToAaruushTile extends Tile {

    public NewToAaruushTile(Context context, AttributeSet attrs) {
        super(context, attrs, "New to Aaruush ?", 2, 1, Color.parseColor("#0099CC"), Color.parseColor("#6DCAEC"), R.drawable.newtoaaruush_icon);

        addTileScreenPage("New to Aaruush ?", ComingSoonPage.class, new String[]{});
    }

}