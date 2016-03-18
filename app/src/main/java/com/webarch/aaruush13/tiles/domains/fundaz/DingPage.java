package com.webarch.aaruush13.tiles.domains.fundaz;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class DingPage extends EventPage {

    public DingPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Aaruush presents to you the ultimate designing event to mark the advent of the creative - both technical and artistic, innovation among the youth. " + "This event provides the motivated youth a platform to highlight their creative skills in front of a wide audience and experienced creative artists");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Aaruush presents to you the ultimate designing event to mark the advent of the creative - both technical and artistic, innovation among the youth. " + "This event provides the motivated youth a platform to highlight their creative skills in front of a wide audience and experienced creative artists");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Eliminator</b><br>" +
                "It basically involves a set of very interesting questions which are sure to get you into the \"fun zone\" mode..!! It tests one's basic knowledge about designing.<br><br>" +
                "<b>Round 2 - Beat D Code</b><br>" +
                "The 2nd round delves deeper into one's ability to think out of the box. " +
                "The offbeat questions tests the creative skills and talents of the competitors!<br><br>" +
                "<b>Round 3 - DeMystify</b><br>" +
                "It includes a task based on their ability to effectively recreate an object using the materials provided.<br><br>" +
                "<b>Round 4 - Untangled</b><br>" +
                "The finalists will be required to find the solutions to the problems, situations and scenarios provided to them in a feasible and practical manner."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Padmini Manivannan</b><br>" +
                "padu.m.94@gmail.com<br>" +
                "+91-91761 54339<br><br>" +
                "<b>Himansu Pandey</b><br>" +
                "himansuarjun@gmail.com<br>" +
                "+91-98400 69961<br><br>" +
                "<b>Krishna Balakrishnan</b><br>" +
                "krishbee@yahoo.co.in<br>" +
                "+91-94980 04691<br><br>" +
                "<b>Aarthi Murali</b><br>" +
                "aarthi.ap8@gmail.com<br>" +
                "+91-99402 46698"));
    }

}