package com.webarch.aaruush13.tiles.domains.online;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class IntrudeTheCastlePage extends EventPage {

    public IntrudeTheCastlePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Attacked by the strongest enemies, the Prince of Baldargan must save his kingdom by INTRUDING the Witch Castle, where lies their only \"HOPE\". " + "The path contains several obstacles that he must overcome to reach \"The Destination\".");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Attacked by the strongest enemies, the Prince of Baldargan must save his kingdom by INTRUDING the Witch Castle, where lies their only \"HOPE\". " + "The path contains several obstacles that he must overcome to reach \"The Destination\".");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Tower to Castle</b><br>" +
                "12 days before AARUUSH. 10 doors, i.e. questions<br><br>" +
                "<b>Round 2 - Castle to Dungeon</b><br>" +
                "8 days before AARUUSH. 10 doors, i.e. questions<br><br>" +
                "Both rounds have maximum of 10 questions split across 3 paths. " +
                "Each path has different number of questions. " +
                "Points are awarded with respect to the path chosen."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Chandrashekhar Singh</b><br>" +
                "shekhar003007@gmail.com<br>" +
                "+91-99622 44695<br><br>" +
                "<b>Punit Gupta</b><br>" +
                "punit.g7@gmail.com<br>" +
                "+91-98403 09508<br><br>" +
                "<b>Shashank Prasad</b><br>" +
                "shashank1692@gmail.com<br>" +
                "+91-97907 71629"));
    }

}