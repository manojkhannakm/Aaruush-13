package com.webarch.aaruush13.tiles.domains.xzone;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class SurvivorsQuestPage extends EventPage {

    public SurvivorsQuestPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("This is an event which focuses on the creativity and the general knowledge of participants and also tests their logical reasoning abilities.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "This is an event which focuses on the creativity and the general knowledge of participants and also tests their logical reasoning abilities.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1.1 - NOKIA FREAK</b><br>" +
                "This round is all about connectors in which 6 visual clips of different famous personalities will be put up and participants are required to find the connection between those persons.<br><br>" +
                "<b>Round 1.2 - CRYPTOGEEK</b><br>" +
                "As the name suggests, this round is about cryptography. Participants are required to decode the message given to them.<br><br>" +
                "<b>Round 2 - BEST OF QUEST</b><br>" +
                "This round is all about unraveling riddles in a way which has not been seen before in any other treasure hunt. The participants are required to approach several places where they would be asked questions and are expected to give the right answers.<br><br>" +
                "<b>Round 3 - TRAMP TO TRIUMPH</b><br>" +
                "This round strictly tests the creativity of the participants and makes them zealous. It involves building castles and protecting it from their foes."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Prabha Tiwari</b><br>" +
                "+91-94446 25123<br><br>" +
                "<b>MS Vivek</b><br>" +
                "+91-98846 86275"));
    }

}