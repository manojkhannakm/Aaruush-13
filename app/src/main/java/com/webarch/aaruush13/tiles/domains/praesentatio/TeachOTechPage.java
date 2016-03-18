package com.webarch.aaruush13.tiles.domains.praesentatio;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class TeachOTechPage extends EventPage {

    public TeachOTechPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Technical dexterity is a word that is used more often than understood. " +
                "The event Teach-O-Tech, tries to bring out the best of teaching skills from its participants with a sound technical base to build upon. " +
                "The way the person presents, interprets a situation and how easily can he/she convey it to others, is what will be tested. " +
                "Knowledge has a diktat of spreading into nascent minds and to transcend boundaries by incorporating ideas into these minds, is what this event is all about.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Technical dexterity is a word that is used more often than understood. " +
                "The event Teach-O-Tech, tries to bring out the best of teaching skills from its participants with a sound technical base to build upon. " +
                "The way the person presents, interprets a situation and how easily can he/she convey it to others, is what will be tested. " +
                "Knowledge has a diktat of spreading into nascent minds and to transcend boundaries by incorporating ideas into these minds, is what this event is all about.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Tease-D-Brains</b><br>" +
                "Minimum of 50 technical words will be displayed on the screen for maximum 1 minute. " +
                "After 1 minute, the display will be turned off and the participants has to write maximum number of words they remember. " +
                "Also, within the given time they have to write 5 technical sentences from any of the words displayed and 5 abbreviations(as provided in the paper). " +
                "Time limit is 2-3 minutes. " +
                "Judgment will be based on maximum number of words written, formation of sentences and abbreviations.<br>" +
                "<b>Rules & Regulations</b><br>" +
                "* 1 mark will be deducted on writing of non-displayed words.<br>" +
                "* The participant should start writing only after the display is turned off. Instant disqualification will be done if any participant starts writing before being asked to.<br>" +
                "* Cell phone usage is strictly prohibited inside the hall.<br><br>" +
                "<b>Round 2 - Video Perception And Description Test</b><br>" +
                "A video will be partially played in two halves. " +
                "The participants will have to write about what will happen next in the video in about 3 minutes. " +
                "Then the other part of the video will be played(just to show it to the participants). " +
                "The videos will be on various random topics with average duration of two minutes.<br>" +
                "<b>Rules & Regulations</b><br>" +
                "* The videos will not be played twice.<br>" +
                "* Silence is mandatory inside the hall.<br><br>" +
                "<b>Round 3 - Speak-A-Pic</b><br>" +
                "A picture will be provided to individual participants and he/ she will be given 1 minute time to prepare herself and has to deliver a technical speech on that picture in another minute. " +
                "This will test the innovative and analytical skill and interpretation skills too.<br>" +
                "<b>Rules & Regulations</b><br>" +
                "* Participants must stick to the time limit exceeding which will cause in mark reduction.<br>" +
                "* No paper and pen is allowed inside the hall.<br><br>" +
                "<b>Round 4 - Suspense Round</b><br>" +
                "Coming soon..."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Avik Dutta</b><br>" +
                "avikdutta0801@gmail.com<br>" +
                "+91-97910 19506<br><br>" +
                "<b>Prabhav Manchanda</b><br>" +
                "manchandaprabhav@gmail.com<br>" +
                "+91-99629 38569<br><br>" +
                "<b>Sparsh Ravi Kumar Lata</b><br>" +
                "tropican74@gmail.com<br>" +
                "+91-72998 88952<br><br>" +
                "<b>Karthik Mehta</b><br>" +
                "+91-94445 85972"));
    }

}