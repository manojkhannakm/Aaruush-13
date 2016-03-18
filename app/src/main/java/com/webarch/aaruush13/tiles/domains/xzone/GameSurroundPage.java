package com.webarch.aaruush13.tiles.domains.xzone;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class GameSurroundPage extends EventPage {

    public GameSurroundPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("All work and no play makes Jack a dull boy! " +
                "For all you Game savvy people out there. " +
                "It is time to embrace the gamer in you! Game Surround has reincarnated... " +
                "Get ready to witness your dreams as a gamer come true in this sweet haven! " +
                "So, what are you waiting for? Gear up and unleash your bag of tricks to beat them all! " +
                "Be a part of game surround and show the world the gaming skills you have.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "All work and no play makes Jack a dull boy! " +
                "For all you Game savvy people out there. " +
                "It is time to embrace the gamer in you! Game Surround has reincarnated... " +
                "Get ready to witness your dreams as a gamer come true in this sweet haven! " +
                "So, what are you waiting for? Gear up and unleash your bag of tricks to beat them all! " +
                "Be a part of game surround and show the world the gaming skills you have.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>FIFA</b><br>" +
                "The event will comprise of 4 rounds<br>" +
                "<b>Qualifying Round</b> - Complete Match for 8 minutes.<br>" +
                "<b>Elimination Round</b> - Complete Match for 10 minutes.<br>" +
                "<b>Semi-Final Round</b> - Complete Match for 10 minutes.<br>" +
                "<b>Final Round</b> - Complete Match for 12 minutes.(If time permits, Finals will be best of three matches)<br>" +
                "Every round will be a Knock out round.<br><br>" +
                "<b>DOTA</b><br>" +
                "<b>Qualifying Round</b> - Match for 45 minutes(Selection based on Scores)<br>" +
                "<b>Elimination Round</b> – Match for 1 hour(Selection based on Scores)<br>" +
                "<b>Semi</b>- Final Round – Complete Match<br>" +
                "<b>Final</b> – Complete Match<br><br>" +
                "<b>Counter Strike</b><br>" +
                "<b>Qualifying Round</b> – Best of 10 rounds.<br>" +
                "<b>Elimination Round</b> – Best of 15 rounds.<br>" +
                "<b>Semi Final Round</b> – Best of 20 rounds.<br>" +
                "<b>Final Round</b> – Best of 10 rounds(3 maps)."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Vishal</b><br>" +
                "+91-98848 45212<br><br>" +
                "<b>Saptarshi</b><br>" +
                "+91-97890 25935<br><br>" +
                "<b>Venkatesh</b><br>" +
                "+91-99629 02535<br><br>" +
                "<b>Nadeem</b><br>" +
                "+91-96001 00355"));
    }

}