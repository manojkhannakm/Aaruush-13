package com.webarch.aaruush13.tiles.domains.bluebook;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class BloodAndBonesPage extends EventPage {

    public BloodAndBonesPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Have you ever experienced the thrill of solving crime, " +
                "analyzing actual crime scene evidence and think that you have it in to become the next Sherlock Holmes? Join us, " +
                "as \"Blood and Bones\" takes forensic biology to a whole new exciting level.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "This event is for ardent lovers of crime scene investigations, forensics and the science that lies behind it. " + "With the tag line of 'Because evidence never lies...' blood and bones is an event that will take forensic sciences to a whole new level and unveil the mystery behind crime solving.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "This round mainly tests ones logical reasoning, skills of deduction and power of observation. " +
                "The teams will be allowed to move the next round after winning the battle of wits.<br><br>" +
                "<b>Round 2</b><br>" +
                "Round 2 is divided into 2 phases.<br>" +
                "<b>Phase 1</b><br>" +
                "The teams will be given a case to solve along with the evidence of the crime after which an evidence report must be prepared.<br>" +
                "<b>Phase 2</b><br>" +
                "This phase involves piecing together the evidence provided to the participants in six Ziploc bags after which they will have to answer a questionnaire based on the evidence. " +
                "This round basically tests the understanding and implementation of the team's forensic techniques.<br><br>" +
                "<b>Round 3</b><br>" +
                "<b>Level 1</b><br>" +
                "The teams selected from the previous round will be given a crime and a budget and will be provided with various services like DNA analysis, fingerprint analysis, etc. " +
                "They must select the services required within their budget and keeping the crime scene in mind. " +
                "The participants will get the results only for the forensic techniques they have chosen, using which the crime is to be solved.<br>" +
                "<b>Level 2</b><br>" +
                "This level of the round takes the participants deep into the realm of forensics wherein they will have to analyse laboratory evidence like toxicology reports and collect all the evidence from different locations. " +
                "The teams will then have to utilize the techniques learnt in the previous rounds as well as their technical and scientific knowledge to analyze and form a conclusion on the given case in hand."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Pournima Prabhakar</b><br>" +
                "pournima.p@gmail.com<br>" +
                "+91-87545 57270<br><br>" +
                "<b>Preethi Rajamannar</b><br>" +
                "pr.iamcrazy@gmail.com<br>" +
                "+91-98409 41550<br><br>" +
                "<b>Chaitanya Patel</b><br>" +
                "chaitupatel@in.com<br>" +
                "+91-99629 40199"));
    }

}