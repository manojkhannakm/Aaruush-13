package com.webarch.aaruush13.tiles.domains.yuddhame;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class WebODesignPage extends EventPage {

    public WebODesignPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("The event revolves around the Web Development Platform. " +
                "As the theme of Aaruush says \"Reinforcing Basics Transcending Boundaries\", this event incorporates all that by dwelling into the the basics of Web Development and ends at a somewhat higher level as the event proceeds. " +
                "The event involves all the major concepts involved in designing of a website from scratch.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "The event revolves around the Web Development Platform. " +
                "As the theme of Aaruush says \"Reinforcing Basics Transcending Boundaries\", this event incorporates all that by dwelling into the the basics of Web Development and end up with a somewhat higher level as the event proceeds. " +
                "Starting from Quiz, going to the frontend and then ending up in the backend is the main aim of the event. " +
                "The event involves all the major concepts involved in designing of a website from Scratch! " +
                "The technologies which are going to be used in the event are HTML, CSS, PHP, MySQL.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Quiz</b><br>" +
                "1. In this Round we'll ask the contestants questions on HTML5, PHP and CSS3 fundamentals.<br>" +
                "2. There will be 50 questions with internal tie-breaking markers.<br>" +
                "3. No negative markings. Number of contestants moving onto the next round depends on team count.<br>" +
                "4. In case of tie, the tie-break marker scores will be taken into consideration.<br>" +
                "5. The round duration is 1 hour.<br><br>" +
                "<b>Round 2 - Design It</b><br>" +
                "1. In this Round they'll have to Design a Layout of the Website shown to them, and beautify using CSS3.<br>" +
                "2. The work will be judged on how unique and intuitiveness that has been put into the page given to them.<br>" +
                "3. The round duration is 2 hrs.<br><br>" +
                "<b>Round 3 - Paint it and Code it</b><br>" +
                "1. In this round, each group will be given a topic for which they have to Draw it on a piece of paper/use Photoshop or Paint.<br>" +
                "2. Then they will be exchanged and then they have to code whatever design they get.<br>" +
                "3. Duration is 2.5 hrs.<br>" +
                "4. Same criteria as previous round for selection of teams.<br><br>" +
                "<b>Round 4 - Registeration and Login</b><br>" +
                "1. In this round, each group has to develop a registration and login system with a profile page for users.<br>" +
                "2. The winners would be selected based on the following criteria.<br>" +
                "3. The cleanness of the UI, validations of form fields, prevention of SQLi / XSS etc and intuitiveness...<br>" +
                "4. The duration for this round would be again 3 hrs."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Prabhu Marappan</b><br>" +
                "prabhum.794@gmail.com<br>" +
                "+91-96886 48050<br><br>" +
                "<b>Akhilesh</b><br>" +
                "Akhi.ph@gmail.com<br>" +
                "+91-98407 91107<br><br>" +
                "<b>Aasmat Kaur</b><br>" +
                "aasmatguron@yahoo.co.in<br><br>" +
                "+91-99629 39709"));
    }

}