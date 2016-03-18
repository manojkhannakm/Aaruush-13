package com.webarch.aaruush13.tiles.domains.fundaz;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class TheUncommonSensePage extends EventPage {

    public TheUncommonSensePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("\"Mind is the only limitless entity and can not be binded by any walls.\" - ANONYMOUS. " +
                "The theme of Aaruush is - TOWARDS INFINITY..." +
                "The knowledge of the books is limited to what the person reads or researches upon. " +
                "But the mind is one virtual phenomenon that goes beyond any such bookish limits and just flows towards the INFINITY.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Aaruush is full of mind-boggling events that make the contenders compete on the basis of their knowledge in either coding or other technicalities. " +
                "Still a event that makes them exercise their brain and that makes them ponder like they have never done before is missing. " +
                "We bring that lively, enjoyable and yet a challenging event to Aaruush.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Smart Idiot Or Street Smart</b><br>" +
                "This round constitutes of selecting the contestants who are able to answer the basic common sense queries. " +
                "Any person who approaches for the registration will be asked a random set of 10 questions out of which if he/she answers 7, they qualify for round 2.<br><br>" +
                "<b>Round 2 - Tap - Out</b><br>" +
                "In this round a set of teams are made to sit in one class. " +
                "A story is projected to all of them and the team that raises their hand first is taken out of the class. " +
                "Their answer and the time they took are noted simultaneously. " +
                "Once a team takes an attempt at an answer, the story is changed.<br><br>" +
                "<b>Round 3 - Knock Out Punch</b><br>" +
                "In this round two teams will compete against each other. " +
                "Both the teams will be given three stories to solve and a time limit of 20 minutes in all. " +
                "The team that solves the stories to the maximum extent in the minimum time will eliminate the counter part.<br><br>" +
                "<b>Round 4 - Mind Hunters</b><br>" +
                "The 7 teams that qualify for this round will get riddles pointing to location in the \"Tech Park\". " +
                "The teams are expected to crack this riddle and reach there next clue. " +
                "The teams can also take hints from the helpdesk of the event but they wil be facing time penalties."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Rajat Jhajhria</b><br>" +
                "rajatjhajhria@yahoo.com<br>" +
                "+91-72006 17405<br><br>" +
                "<b>Siddhant Atreya</b><br>" +
                "siddhant.atreya@gmail.com<br>" +
                "+91-95000 68163<br><br>" +
                "<b>Eshlok Sharma</b><br>" +
                "eshlok1@gmail.com<br>" +
                "+91-84384 45898<br><br>" +
                "<b>Neha</b><br>" +
                "nehabarmecha.30@gmail.com<br>" +
                "+91-89405 82005"));
    }

}