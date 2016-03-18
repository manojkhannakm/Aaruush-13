package com.webarch.aaruush13.tiles.spotlight;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.model.GraphUser;
import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;
import com.webarch.aaruush13.tiles.ComingSoonPage;

public class SpotlightTile extends Tile {

    public SpotlightTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Spotlight", 2, 2, Color.parseColor("#FF8A00"), Color.parseColor("#FFBD21"), R.drawable.spotlight_icon);

        addTileScreenPage("Spotlight", ComingSoonPage.class, new String[]{});
    }

    @Override
    public void facebookLoggedIn(GraphUser graphUser) {
        LinearLayout liveTile1Layout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.spotlight_live_tile_1, null, false);
        ((TextView) liveTile1Layout.findViewById(R.id.spotlight_live_tile_1_1)).setText("Hi! " + graphUser.getName());

        resetTile();
        setLiveTiles(new View[]{liveTile1Layout}, false, false);
    }

    @Override
    public void facebookLoggedOut() {
        resetTile();
        setLiveTiles(null, false, true);
    }

}