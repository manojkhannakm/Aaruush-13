package com.webarch.aaruush13.tiles.domains.robogyan;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class RoboRangersPage extends EventPage {

    public RoboRangersPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("The event is based on the recruitment of a king's army and the situation when a winner has to be selected when as many as half of the recruited members turn to mutiny.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "The event is based on the recruitment of a king's army and the situation when a winner has to be selected when as many as half of the recruited members turn to mutiny.");

        eventCollapsibleView.addPanel("Details", "The event is based on a test of the bot's durability and fighting capabilities, as the first round is to guide it through the all terrain and then the remaining two rounds are based on fighting, Robo war.");

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* There will be negative points for touching the bot.<br>" +
                "* If the participant is aggressive with the mechanism's and breaks it, then he can be disqualified.<br>" +
                "* Judges decision on the points scored by the participant is final and cannot be challenged.<br>" +
                "* The participant can include mechanisms in the bot so as to carry or drag the balls to the pits."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Avishek Mishra</b><br>" +
                "louismishra93@gmail.com<br>" +
                "+91-81449 14242<br><br>" +
                "<b>Vikas Singh</b><br>" +
                "vikas.singh2311@gmail.com<br>" +
                "+91-78118 37736<br><br>" +
                "<b>Akshay Agarwal</b><br>" +
                "akshayagg009@gmail.com<br>" +
                "+91-73050 02905<br><br>" +
                "<b>Shivang Pathak</b><br>" +
                "shivang12195@gmail.com<br>" +
                "+91-99629 40139"));
    }

}