package com.webarch.aaruush13.tiles.workshops;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;

public class WorkshopsTile extends Tile {

    public WorkshopsTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Workshops", 1, 1, Color.parseColor("#3B4B98"), Color.parseColor("#6E6EFF"), R.drawable.workshop_icon);

        LinearLayout liveTileLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.workshops_live_tile, null, false);
        ((TextView) liveTileLayout.findViewById(R.id.workshops_live_tile_1)).setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text3 * 3);

        setLiveTiles(new View[]{liveTileLayout}, true, false);

        addTileScreenPage("Augmented Reality", AugmentedRealityPage.class, new String[]{});
        addTileScreenPage("Bridge Design", BridgeDesignPage.class, new String[]{});
        addTileScreenPage("HackTrack", HackTrackPage.class, new String[]{});
        addTileScreenPage("Mobile Botrix", MobileBotrixPage.class, new String[]{});
        addTileScreenPage("Transformer Botix", TransformerBotixPage.class, new String[]{});
        addTileScreenPage("Webpreneur", WebpreneurPage.class, new String[]{});
        addTileScreenPage("Who Shot The Sherlock", WhoShotTheSherlockPage.class, new String[]{});
    }

}