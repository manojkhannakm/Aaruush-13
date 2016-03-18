package com.webarch.aaruush13.tiles.domains.robogyan;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class RoboVenturePage extends EventPage {

    public RoboVenturePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("It is an event where robots have to overcome \"mechanical hurdles\" and race to the finish line.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Robo venture, as the name suggests, is a robotics team event based on the concept of hurdle race. Accordingly, it involves robots crossing hurdles and racing across obstacle courses to win.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("It's a single round game. The race is for one lap across the course.<br><br>" +
                "<b>Gameplay</b><br>" +
                "It is a single lap race. " +
                "The bots will have to overcome hurdles and obstacles based on forces and torques like inclinations, moving bridges and rotating platforms that will necessarily try to hamper the momentum of the robots. " +
                "The bot with the best time shall be declared winners."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Number of robot handlings allowed: 3 (when robots get stuck/fall, wires tangle etc).<br>" +
                "* Hopping, jumping and destruction inside the arena will not be tolerated.<br>" +
                "* The permissible team size is between 1 to 3 members.<br>" +
                "* 220V AC Power supply will be provided. The participating teams must bring own extension board, adaptors/eliminators of the required voltage rating.<br>" +
                "* The Game rules are subject to change by organizers as and when required. Any change in rules, if any, will be notified to the participants.<br>" +
                "* All the judgments by the judges/referees will be final."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Subin Philip</b><br>" +
                "suby124@gmail.com<br>" +
                "+91-87545 52477<br><br>" +
                "<b>Syed Moshin</b><br>" +
                "mohsinsyd12@gmail.com<br>" +
                "+91-99400 22616<br><br>" +
                "<b>C. V. Sai Srinivasan</b><br>" +
                "srinivasansai36@gmail.com<br>" +
                "+91-97910 47665<br><br>" +
                "<b>Bibhudata Patnaik</b><br>" +
                "+91-99400 23044"));
    }

}