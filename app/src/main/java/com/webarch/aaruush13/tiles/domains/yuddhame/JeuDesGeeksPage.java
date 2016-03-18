package com.webarch.aaruush13.tiles.domains.yuddhame;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class JeuDesGeeksPage extends EventPage {

    public JeuDesGeeksPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Numerous malicious technical events are present in Aaruush but none serve to all the sections of coders. " +
                "Here is an event that interests anyone from a basic C-coder to a pro java developer. " +
                "Coders or not, geeks or gamers, this event is for you. " +
                "The test of basic computing and coding knowledge to pro level programming skills awaits. " +
                "It intends at teaching game development along with coding in a whole new way.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Numerous malicious technical events are present in Aaruush but none serve to all the sections of coders. " +
                "Here is an event that interests anyone from a basic C-coder to a pro java developer. " +
                "Coders or not, geeks or gamers, this event is for you. " +
                "The test of basic computing and coding knowledge to pro level programming skills awaits. " +
                "It intends at teaching game development along with coding in a whole new way.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Coder's Quest</b><br>" +
                "(Day 1, 20 minutes each participant)<br>" +
                "1. This round has two levels, both the levels are tested simultaneously.<br>" +
                "<b>Level 1 - Just_Logic</b><br>" +
                "1. MCQ's for coding aptitude on c, c++ and java (separate papers for each language, participant can opt any one).<br>" +
                "2. A set of questions based on DATA STRUCTURES and ALGORITHMS will be given.<br>" +
                "<b>Level 2 - Cross_Word</b><br>" +
                "1. A set of 10 questions will be given. Five across, and, five down. Fill the answers in the cross-word as per the question number whether across or down.<br><br>" +
                "<b>Round 2 - Mind the Next...!!!</b><br>" +
                "(Day 2, Team based)<br>" +
                "1. This is a treasure hunt round coagulated with basic programing problems.<br>" +
                "2. Each participant will be given a programing code whose output will give you the hint of next location where you will get the next problem.<br>" +
                "3. You have to reach the 5th level like this. (Answer 5 questions to complete the round)<br>" +
                "4. Evaluation will be done based on the accuracy of the path and timing.<br><br>" +
                "<b>Round 3 - Game On</b><br>" +
                "(Day 3, Team Based)<br>" +
                "1. This is a team based level.<br>" +
                "2. Each participant works in a game developing environment.<br>" +
                "3. There's no necessity for coding in this level.<br>" +
                "4. Participants have to develop a game.<br>" +
                "5. Based on creativity, innovation and implementation of idea, interface provided points will be awarded.<br>" +
                "6. A demo will be given about the gaming environment and Resources, links will be provided after the second round.<br><br>" +
                "<b>Round 4 - Full and Final</b><br>" +
                "(Day 3, Individual Round)<br>" +
                "1. This is an individual round where the finalists will be given a code (code of codes).<br>" +
                "2. The code will basically consist of a program done in more than one language i.e., c, c++, java etc. and all lines of codes mixed together.<br>" +
                "3. The finalist who chose either of the languages are required to extract the code in his/her respective language. However, the extracted code will have all kinds of errors viz. syntactical error, semi colon missing etc. One needs to rectify the errors and submit the final code.<br><br>" +
                "<b>Game of Powerplay</b><br>" +
                "This is also an individual level.<br>" +
                "A common problem with missing codes will be provided to all the participants.<br>" +
                "Participants have to fill the code and complete the logic missing within the stipulated time period.<br>" +
                "Hints will be given as comments in the codes."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Ankit Joshi</b><br>" +
                "+91-98844 75693<br><br>" +
                "<b>Ankit Agrawal</b><br>" +
                "+91-97910 14271<br><br>" +
                "<b>Vidushi Singh</b><br>" +
                "+91-80562 23064"));
    }

}