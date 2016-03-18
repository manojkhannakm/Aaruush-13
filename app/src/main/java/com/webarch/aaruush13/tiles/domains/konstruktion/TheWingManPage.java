package com.webarch.aaruush13.tiles.domains.konstruktion;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class TheWingManPage extends EventPage {

    public TheWingManPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("To design, construct and test the basic skills an individual has in the field of Aerospace engineering.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "This event tests the basic skills of designing and construction that every Aerospace engineer should have.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Aeroplana (Paper Plane)</b><br>" +
                "There are three different tests in the first round" +
                "The paper planes made by the participants should fulfil three condition<br>" +
                "Endurance (Time of flight in air)<br>" +
                "Distance covered ( Length) as high as possible<br>" +
                "Manoeuvring<br>" +
                "Three different papers will be given to the contestant<br><br>" +
                "<b>Round 2 - Astrothesiae (Paper Rocketry)</b><br>" +
                "To design, construct, and fly paper rockets that will travel the greatest distance possible across a floor model of the solar system. " +
                "In this round, students construct small flying rockets out of paper and propel them by blowing air through a straw. " +
                "For the \"distance\" category, each participant blows air through straw in his or her paper rocket while the volunteer records distances in feet and inches. " +
                "All distances must be measured from the starting line to the point where the rocket first touches the ground or floor -- not to the final resting place if it slides. " +
                "Each participant has up to three chances to get his or her best distance.<br><br>" +
                "<b>Round 3 - Aiolos (Parachute Design)</b><br>" +
                "The groups should build the parachutes on the competition day. " +
                "Only completed models will be deployed and evaluated on that day. " +
                "Sizes and weights of materials provided are determined by the organizers and only will be known by the participating groups on the competition day. " +
                "Each group will build a parachute only using materials stated and will be allowed to use any combination of the given materials. " +
                "Metal washer acting as load will be hooked up to the completed parachutes with strings. " +
                "The participants will release the loaded parachute from the trebuchet. " +
                "The parachute must have a self operating mechanism and must open mid way in the air after release. " +
                "The judges will see the opening mechanism and the time the parachute stays in air before touching the ground."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* The basic idea is to design hence everything should be made of raw material no ready-made planes, rockets, or parachutes will be accepted.<br>" + "* The items must be designed using the materials mentioned ONLY."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Ajay Kumar</b><br>" +
                "arulajay@yahoo.co.in<br>" +
                "+91-88831 89102<br><br>" +
                "<b>Ilayamaran</b><br>" +
                "ilayamarand@gmail.com<br>" +
                "+91-95001 00271<br><br>" +
                "<b>Harsh Kamlesh Sanghavi</b><br>" +
                "harshks@ymail.com<br>" +
                "+91-99529 61771<br><br>" +
                "<b>Divya Agarwal</b><br>" +
                "famedivya@gmail.com<br>" +
                "+91-98405 07793"));
    }

}