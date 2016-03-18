package com.webarch.aaruush13.tiles.domains;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;
import com.webarch.aaruush13.tiles.domains.bluebook.BluebookPage;
import com.webarch.aaruush13.tiles.domains.fundaz.FundazPage;
import com.webarch.aaruush13.tiles.domains.konstruktion.KonstruktionPage;
import com.webarch.aaruush13.tiles.domains.magefficie.MagefficiePage;
import com.webarch.aaruush13.tiles.domains.online.OnlinePage;
import com.webarch.aaruush13.tiles.domains.praesentatio.PraesentatioPage;
import com.webarch.aaruush13.tiles.domains.robogyan.RobogyanPage;
import com.webarch.aaruush13.tiles.domains.specials.SpecialsPage;
import com.webarch.aaruush13.tiles.domains.xzone.XzonePage;
import com.webarch.aaruush13.tiles.domains.yuddhame.YuddhamePage;

public class DomainsTile extends Tile {

    public DomainsTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Domains", 1, 1, Color.parseColor("#9933CC"), Color.parseColor("#C58BE2"), R.drawable.domains_icon);

        LinearLayout liveTile1Layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.domains_live_tile_1, null, false);
        ((TextView) liveTile1Layout.findViewById(R.id.domains_live_tile_1_1)).setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text3 * 3);

        TextView liveTile2TextView = new TextView(context);
        liveTile2TextView.setGravity(Gravity.CENTER);
        liveTile2TextView.setText(Html.fromHtml("Pre<br>" +
                "Aaruush<br>" +
                "Events"));
        liveTile2TextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text2);
        liveTile2TextView.setTextColor(Color.WHITE);

        setLiveTiles(new View[]{liveTile1Layout, liveTile2TextView}, true, false);

        addTileScreenPage("Bluebook", BluebookPage.class, new String[]{});
        addTileScreenPage("Fundaz", FundazPage.class, new String[]{});
        addTileScreenPage("Konstruktion", KonstruktionPage.class, new String[]{});
        addTileScreenPage("Magefficie", MagefficiePage.class, new String[]{});
        addTileScreenPage("Online", OnlinePage.class, new String[]{});
        addTileScreenPage("Praesentatio", PraesentatioPage.class, new String[]{});
        addTileScreenPage("Robogyan", RobogyanPage.class, new String[]{});
        addTileScreenPage("Specials", SpecialsPage.class, new String[]{});
        addTileScreenPage("X-zone", XzonePage.class, new String[]{});
        addTileScreenPage("Yuddhame", YuddhamePage.class, new String[]{});
    }

}