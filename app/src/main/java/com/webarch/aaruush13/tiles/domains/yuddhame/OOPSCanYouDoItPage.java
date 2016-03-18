package com.webarch.aaruush13.tiles.domains.yuddhame;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class OOPSCanYouDoItPage extends EventPage {

    public OOPSCanYouDoItPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("This event deals with the different styles of programming. " +
                "Your choice of the language will be given from the very first round, which could be C++ or Java. " +
                "This event is open to students of all streams with knowledge in computer languages. " +
                "The event is all about individual skills.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "This event deals with the different styles of programming. " +
                "Your choice of the language will be given from the very first round, which could be C++ or Java. " +
                "This event is open to students of all streams with knowledge in computer languages. " +
                "The event is all about individual skills.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "The participants will be asked to select either of the two languages C++ or JAVA.<br>" +
                "Depending upon the selected language the participants will be given an MCQ questionnaire which contains 50 questions on the concept of Object Oriented Programming and also include questions like finding the output and errors as well as questions on the history and present application of the language. The time in which the paper is submitted will be noted down.<br>" +
                "Max. Time – 1hr<br><br>" +
                "<b>Round 2</b><br>" +
                "The participants will have to write a basic outline of how they would go about solving the particular problem given to them. It can be an algorithm, flow chart, or a block diagram.<br>" +
                "Max. Time – 45min<br><br>" +
                "<b>Round 3</b><br>" +
                "This round is a programming round. You will be coding a part of the program (in the chosen language) you have made the outline of. You will have to abide by the outline submitted by you, nothing extra will be allowed.<br>" +
                "Max. Time – 2hr<br><br>" +
                "<b>Round 4</b><br>" +
                "This is another programming round where your code has been messed with and you have to debug the errors in the code. You will be allowed to compile only twice.<br>" +
                "Max. Time – 45min<br><br>" +
                "<b>Round 5</b><br>" +
                "This is the final round and starts as soon as the previous round is over. All those who will be able to debug their code will now code the second part of their program. Abiding by the outline submitted is a must.<br>" +
                "Max. Time – 2hr"));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Cell phones should be in the switched off mode. Anyone found using their cell phones will be disqualified.<br>" +
                "* All the rounds are time bound. Timing is an important factor for judgement.<br>" +
                "* Chatting and gestures will not be entertained.<br>" +
                "* The judge's decision will not be questionable.<br>" +
                "* No sheets or bits of paper are allowed. Only pens can be carried into the lab or classroom."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Vidhi Gupta</b><br>" +
                "+91-99529 79162<br><br>" +
                "<b>Deepti Bisht</b><br>" +
                "+91-97898 61479<br><br>" +
                "<b>Pratik Shenoy</b><br>" +
                "+91-78455 14229"));
    }

}