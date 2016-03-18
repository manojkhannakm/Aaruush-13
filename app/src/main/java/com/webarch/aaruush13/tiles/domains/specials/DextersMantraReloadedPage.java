package com.webarch.aaruush13.tiles.domains.specials;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class DextersMantraReloadedPage extends EventPage {

    public DextersMantraReloadedPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("The participants will have to answer basic science questions (10th grade level) to move to the 2nd round where they will be shown \"Dexter report\". " +
                "Based on the report, they will have to answer questions. " +
                "In the third round, they will have to solve a maze in the dark and solve riddles simultaneously to move to fourth round. " +
                "The final round, will have them to perform a set of tasks to finish the challenge.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "The participants will have to answer basic science questions (10th grade level) to move to the 2nd round where they will be shown \"Dexter report\". " +
                "Based on the report, they will have to answer questions. " +
                "In the third round, they will have to solve a maze in the dark and solve riddles simultaneously to move to fourth round. " +
                "The final round, will have them to perform a set of tasks to finish the challenge.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "* The participants must answer the questions as displayed on the screen.<br>" +
                "* Each question will be displayed for a span of 30 seconds.<br>" +
                "* The participants should write their answers in the boxes given to them in the sheet.<br>" +
                "* Each question fetches you 2 points and each star question fetches 5 points.<br>" +
                "* No negative marking.<br><br>" +
                "<b>Round 2</b><br>" +
                "* 100 teams will be qualified for this round.<br>" +
                "* They will be shown a \"dexter report\" about any one of his science projects on the projector screen.<br>" +
                "* 20 questions will be asked based on the report.<br>" +
                "* The answers to all those questions will be in the report.<br>" +
                "* Eight teams with maximum scores move to the third round.<br><br>" +
                "<b>Round 3</b><br>" +
                "* In this round, the participants will have to solve a maze in the dark while their counterparts try to earn more time by solving riddles.<br>" +
                "* Selected 8 teams will be called at specified locations. 2 batches of 4 teams each will be made.<br>" +
                "* One batch will play the round at a time.<br>" +
                "* One of the members of each team (say member-1) will be asked to solve puzzles while the other (member-2) has to perform the Infinity task (maze solving).<br>" +
                "* Total of 30 minutes will be provided for completing the task.<br><br>" +
                "<b>Round 4</b><br>" +
                "* 4 teams will play this round.<br>" +
                "* The teams will have to perform 6-8 set of tasks.<br>" +
                "* Each task will earn them points.<br>" +
                "* If they are unable to figure out the task, they can ask for clue at the expense of their earned points.<br>" +
                "* The tasks will be purely technical."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Romil Gupta</b><br>" +
                "romil.srm@gmail.com<br>" +
                "+91-93624 25297<br><br>" +
                "<b>Kushagra Agarwal</b><br>" +
                "kushagraagarwal@srmuniv.edu.in<br>" +
                "+91-89390 21680<br><br>" +
                "<b>Tejas Pardeshi</b><br>" +
                "Tejaspardeshi22@gmail.com<br>" +
                "+91-81440 72089<br><br>" +
                "<b>Sree Harsha</b><br>" +
                "+91-97908 78503"));
    }

}