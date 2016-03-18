package com.webarch.aaruush13.tiles.domains.bluebook;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class ElequestPage extends EventPage {

    public ElequestPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Entertainment combined with chemistry is what ELEQUEST is all about. " +
                "Here we present to you a plethora of activities with a huge fun quotient and promising rewards. " +
                "So come one and come all and remember to put your freak on as 'FREAK is the new GEEK'.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "With the tagline of \"chemistry can make it or break it\", this event is for every single person even if he or she hates the subject. " + "Elequest tests ones mettle through a series of rounds in a never seen before manner.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - CHEMZAP</b><br>" +
                "Ad zap + Chemistry = CHEMZAP!!<br>" +
                "Here's your chance to prove all those people wrong who think watching TV all day long is of no use. " +
                "Guess the correct answer to the tag lines provided to you and proceed on to the next round.<br><br>" +
                "<b>Round 2 - Chemical Tambola.</b><br>" +
                "Numerical Tambola, a bit too main stream? Try Elequest's Chemical Tambola where you have to strike out elements/compounds instead of numbers by guessing the correct answers to the hints provided to you.<br><br>" +
                "<b>Round 3 - Strip-o-Mania.</b><br>" +
                "To all the lab freaks who like playing with Acids, Alkalis and the tiny but useful Ph paper, here is a chance to put all this together and be creative and wacky. " +
                "Get the correct colour on the Ph paper strip and get your sequence right.<br><br>" +
                "<b>Round 4 - Be Ne Rd Y</b><br>" +
                "Lets increase the technicality a bit without losing out on the fun part. Here are the two parts of round 4<br>" +
                "<b>Mum's the word</b><br>" +
                "Let's test your team's chemistry. Try converting the not so obvious to obvious by using your knowledge bank to the fullest.<br>" +
                "<b>The Final Destination</b><br>" +
                "Here the participants have to unravel the answer first by solving a few reactions and then make a 3D model of all of the reactants and products using the ball and stick kit within a prescribed time limit."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Hrithika Choudhary</b><br>" +
                "hrithika12@yahoo.co.in<br>" +
                "+91-80561 55343<br><br>" +
                "<b>Varun Nair</b><br>" +
                "varunnair@outlook.com<br>" +
                "+91-80560 04838<br><br>" +
                "<b>Akshitha Sriram</b><br>" +
                "akshitha_sriram@yahoo.com<br>" +
                "+91-91761 34314"));
    }

}