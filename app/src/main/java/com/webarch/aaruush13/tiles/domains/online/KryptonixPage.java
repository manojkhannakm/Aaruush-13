package com.webarch.aaruush13.tiles.domains.online;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class KryptonixPage extends EventPage {

    public KryptonixPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Ever fancied to step in the shoes of a decoder, search for hidden clues and get to the hidden treasure? " + "KRYPTONIX allows you to experience the thrill from the comfort of your room and play the online cryptography event.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Ever fancied to step in the shoes of a decoder, search for hidden clues and get to the hidden treasure? " + "KRYPTONIX allows you to experience the thrill from the comfort of your room and play the online cryptography event.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("You need to dig out the answers to get to the next clue and one step closer to the final prize. " + "Look for clues, take the help of every scam, con, hustle, hoodwink, gambit, flimflam, stratagem, and bamboozle you can think of, to get to the final prize."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Aman Sharma</b><br>" +
                "amansharma.811@gmail.com<br>" +
                "+91-89391 99424<br><br>" +
                "<b>Nilesh Agnihotri</b><br>" +
                "agnihotri12.9@gmail.com<br>" +
                "+91-89391 99464<br><br>" +
                "<b>Sharanjeet Singh Mago</b><br>" +
                "sharanjeetsinghmago@gmail.com<br>" +
                "+91-98405 79720"));
    }

}