package com.webarch.aaruush13.tiles.domains.konstruktion;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class MedievalWarfarePage extends EventPage {

    public MedievalWarfarePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("The Event is based upon Medieval Warfare Engineering and the Technology. " +
                "It will involve fabrication of various Ranged Weapons like \"The Catapult\", \"Trebuchets\" etc. displaying the Mechanics behind the Weapon. " +
                "This Event includes design, build, testing and competition of models against each other.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "The Event is based upon Medieval Warfare Engineering and the Technology. " +
                "It will involve fabrication of various Ranged Weapons like \"The Catapult\", \"Trebuchets\" etc. displaying the Mechanics behind the Weapon. " +
                "This Event includes design, build, testing and competition of models against each other.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Day 1</b><br>" +
                "<b>1. </b>All teams will be given an MCQ paper to test their basic knowledge on basics of medieval weaponry such as catapults etc. and also on basics of tools. " +
                "The questions will be simple so as to ensure teams have a minimal understanding prior to proceeding to the build. " +
                "The top 50% of teams will proceed to the next round.<br>" +
                "Duration: 30 minutes.<br>" +
                "<b>2. I) Design and build of model</b><br>" +
                "Teams must design and build a model of their design using Popsicle sticks, bands and glue. " +
                "The design must be a structural replica of the main model they wish to build. " +
                "To make the event more challenging the teams will be given the list of materials that will be available if they proceed to build. " +
                "Teams must also mention the materials they will need to build the main machine. They will also be given a total virtual cost of the various materials provided. " +
                "The total value of the bill of materials of their design must be within the limit that will be allowed.<br>" +
                "Duration: 60 minutes.<br>" +
                "<b>II) Evaluation of build</b><br>" +
                "The judges will evaluate the design along with a viva interaction with each team on the models they have built. " +
                "The criteria for judging will be creativity, simplicity, feasibility, virtual cost, structure etc. " +
                "The teams will be awarded points based on the evaluation by the judges. " +
                "The top 10-12 teams will be allowed to proceed to the next round.<br>" +
                "Duration: Few minutes per team; at the discretion of the judges.<br><br>" +
                "<b>Day 2</b><br>" +
                "<b>3. Build</b><br>" +
                "The shortlisted 10-12 teams will be allowed to proceed for the build. " +
                "These teams will be provided ONLY the materials in the quantity they had mentioned in the bill of materials. " +
                "Although, Teams will be allowed a tolerance of 10% of extra material during the build. " +
                "Teams will be provided access to the workshop and tools.<br>" +
                "Duration: 10 hrs; Teams may also test during this period and make changes.<br><br>" +
                "<b>Day 3</b><br>" +
                "<b>4. The capability tests</b><br>" +
                "The teams which have completed their build within the stipulated time will proceed to this round. " +
                "The completed builds will then be subjected to various tests such as range test, payload test, accuracy test etc. " +
                "Teams will be awarded points based on their performance in this round.<br>" +
                "<b>5. The finale-destruction course</b><br>" +
                "The top 5-6 teams will proceed to this round. " +
                "This round will have a structure that the teams will have to destroy using their models. " +
                "Each section they destroy will carry a set number of points. " +
                "The destruction must be complete within the set number of trials. " +
                "The team with the maximum number of points wins."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* The Model has to be within the following Dimensional limitations:<br>" +
                " - Length: 30-35 inches<br>" +
                " - Breadth: 20-25 inches<br>" +
                " - Height: 20-25 inches<br>" +
                "* The model cost must be within the virtual cost.<br>" +
                "* Time limit adherence is a must.<br>" +
                "* Teams that proceed to the build must use only the materials that were mentioned by them in the bill of materials.<br>" +
                "* The materials mentioned in the bill of material must be in the list of materials as given by the organisers prior to Round 1."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Md. Shayan</b><br>" +
                "+91-99400 19079<br>" +
                "shayanhusain@gmail.com<br><br>" +
                "<b>Shobhit Madan</b><br>" +
                "shobit_madan@yahoo.co.in<br>" +
                "+91-97907 66897<br><br>" +
                "<b>Tarun Rao</b><br>" +
                "tarunrao.india@gmail.com<br>" +
                "+91-99400 67858<br><br>" +
                "<b>Ivjyot Singh</b><br>" +
                "oberoi.iv@gmail.com<br>" +
                "+91-99405 71635"));
    }

}