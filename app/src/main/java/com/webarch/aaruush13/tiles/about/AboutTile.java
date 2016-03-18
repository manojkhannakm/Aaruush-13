package com.webarch.aaruush13.tiles.about;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;

public class AboutTile extends Tile {

    public AboutTile(Context context, AttributeSet attrs) {
        super(context, attrs, "About", 1, 1, Color.parseColor("#007DFF"), Color.parseColor("#00BEFF"), R.drawable.about_icon);

        ImageView liveTile1ImageView = new ImageView(getContext());
        liveTile1ImageView.setImageResource(R.drawable.about_live_tile_1);

        ImageView liveTile2ImageView = new ImageView(getContext());
        liveTile2ImageView.setImageResource(R.drawable.about_live_tile_2);

        setLiveTiles(new View[]{liveTile1ImageView, liveTile2ImageView}, false, false);

        addTileScreenPage("Aaruush", AaruushPage.class, new String[]{
                "aaruush",
                "apj",
                "abdul",
                "kalam",
                "legacy"
        });
        addTileScreenPage("SRM University", SRMUniversityPage.class, new String[]{
                "srm",
                "university",
                "campus",
                "research"
        });
    }

}