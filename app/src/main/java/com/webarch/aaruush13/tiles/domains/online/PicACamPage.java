package com.webarch.aaruush13.tiles.domains.online;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class PicACamPage extends EventPage {

    public PicACamPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Pic-a-cam is all about a multiple round online photography event where you are required to take photographs on a given theme. " +
                "All the enthusiastic photographers out there! Its time for you to pick up your cameras and explore the world around you. " +
                "Think creative and give your best shot!");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Pic-a-cam is all about a multiple round online photography event where you are required to take photographs on a given theme. " +
                "All the enthusiastic photographers out there! Its time for you to pick up your cameras and explore the world around you. " +
                "Think creative and give your best shot!");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - juz clickk!!!</b><br>" +
                "A particular theme(\"towards infinity\" would be the theme for round one since it is our theme for Aaruush '13) is given to the participants. The participants are asked to take snapshots relating to the theme in any way and send it to us.<br>" +
                "\"Towards infinity\" might resemble anything like spark, out of the box, star trails, horizons, crowd etc.<br>" +
                "Judging criteria<br>" +
                "Out of the pool all the participants whose photographs are selected by our judges would be eligible for round 2.<br>" +
                "All the qualified participants would be informed prior to the start of second round.<br>" +
                "Basic photography:50%<br>" +
                "Innovation and theme relativity:45%<br>" +
                "Facebook likes:5%<br><br>" +
                "<b>Round 2 - its my story</b><br>" +
                "In this round the participants are required to take a sequence of photos so that they could narrate a story using the photographs.<br>" +
                "The story should be related to the given theme<br>" +
                "Judging criteria<br>" +
                "The limit of photos that one can use is max 30.<br>" +
                "The participants should make sure that their photos are in a sequence.<br>" +
                "The participants should also take care that they not only take good photos but, they are able to convey their story to the judge.<br>" +
                "Basic photography:50%<br>" +
                "Story narration:30%<br>" +
                "Theme relativity:20%"));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* All kind of cameras can be used which give good quality images.<br>" + "* No post editing is allowed."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Srikanth Padmasola</b><br>" +
                "srikanth.aaruush@gmail.com<br>" +
                "+91-76677 68509<br><br>" +
                "<b>Srijan Sharma</b><br>" +
                "srijansharma@live.in<br>" +
                "+91-87545 57271"));
    }

}