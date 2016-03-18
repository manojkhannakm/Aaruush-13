package com.webarch.aaruush13.tiles.domains.robogyan;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class WalkOnTheRopePage extends EventPage {

    public WalkOnTheRopePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Walk on the rope tests the level of stability in robot movements and the participant's control over them.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "The walk-on-rope event will have wireless or manually controlled robots walking on tight ropes and ground on an alternate basis.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "Robots must go from one point to another on a tight rope and should also navigate through hurdles like sudden inclination and declination, slippery ropes to name a few.<br><br>" +
                "<b>Round 2</b><br>" +
                "Robots should walk on interchanging surfaces of planes and rope and also overcome obstacles along the way.<br><br>" +
                "<b>Gameplay</b><br>" +
                "The robots should navigate through rope and plane surfaces while overcoming hurdles and should take the minimum possible time to reach the finish line in the two rounds."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Robots should be designed as per the event regulations along with power capacities.<br>" +
                "* Jamming devices are not allowed.<br>" +
                "* Wheels or parts which could cut, break or damage the rope should not be used.<br>" +
                "* Robots must change track by themselves through pre-designed mechanism.<br>" +
                "* In case the robots fall down from the rope and plane surface, there will be a deduction of 100 points for each fall.<br>" +
                "* Robot Operators should not touch the robot after the game starts. Each touch will attract a deduction of 100 points.<br>" +
                "* For each successful track interchange 250 points will be awarded.<br>" +
                "* Any team that is not ready at the specified time will be disqualified from the competition automatically.<br>" +
                "* Judge's decision shall be treated as final and binding on all.<br>" +
                "* Any bot found damaging the ring will be immediately disqualified.<br>" +
                "* Only one member of the team is allowed to handle the bot. Participants are not allowed to keep anything inside the arena other than their bot."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>N. Guru Aravind</b><br>" +
                "aravind.gowrav99@gmail.com<br>" +
                "+91-87545 06422<br><br>" +
                "<b>R. Narasimha</b><br>" +
                "ripujit.gindam@gmail.com<br>" +
                "+91-74010 74185<br><br>" +
                "<b>V. Surya</b><br>" +
                "surya.v03@gmail.com<br>" +
                "+91-99659 44075"));
    }

}