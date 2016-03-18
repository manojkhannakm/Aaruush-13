package com.webarch.aaruush13.tiles.domains.konstruktion;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class TheBigBridgeTheoryPage extends EventPage {

    public TheBigBridgeTheoryPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Teams have to construct a suspension or cable stayed bridge from given materials which could bear maximum load with minimum deflection. " + "Bridge should be practically feasible and aesthetic.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Teams have to construct a suspension or cable stayed bridge from given materials which could bear maximum load with minimum deflection. " + "Bridge should be practically feasible and aesthetic.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Testing of Aptitude</b><br>" +
                "Team have to solve a questionnaire consisting of objective questions testing the quantitative aptitude of teams.<br>" +
                "Teams have to solve 30 questions in 45 minutes.<br>" +
                "Top 20 teams will qualify for next round.<br><br>" +
                "<b>Round 2 - Bridge designing</b><br>" +
                "Qualified teams have to submit the design of their bridge.<br>" +
                "Design should be made manually on A3 graph papers showcasing different views(Top view, Front view and side view)<br>" +
                "Design should contain all the information regarding dimensions of the bridge and include all other labelling.<br>" +
                "Design once selected, can't be changed while construction.<br>" +
                "Teams have to submit or mail their design once they are informed about their qualification for second round before next morning 9 AM.<br>" +
                "Design should be mailed to thebbtaaruush13@gmail.com.<br>" +
                "Top 7 teams will qualify for the final round.<br><br>" +
                "<b>Round 3 - Construction of Bridge</b><br>" +
                "A suspension or cable stayed bridge with a deck of dimensions 1000mm x 250mm has to be built on a plywood base.<br>" +
                "The clearance of the deck should not be less than 200mm from the plywood base.<br>" +
                "The structure of the bridge should consist of two pylons made of L- shaped aluminium channels (dimensions 20mm X 20mm X 2mm).<br>" +
                "Pylons should be made stronger by implementing innovative design with the given material.<br>" +
                "The deck must be built with a polycarbonate sheet of thickness 1mm with the support of L-shaped aluminium channels (dimensions 25mm x 25mm x 1mm. Extra care must be taken by the teams in designing the deck of the bridge as deflection is one of the more important judging criterions.<br>" +
                "Nylon cables of diameter 1mm will be provided for suspending the deck (A nylon cable of diameter 3mm will be provided for the main cable of the suspension bridge).(A minimum separation of 30mm should be maintained between two adjacent cables).<br>" +
                "The pylons can be erected on the plywood base using the L-clamps.<br>" +
                "The deck shouldn't be directly connected to the pylons, it must be suspended through the cables on the pylons. Any nut and bolt joint between the deck and the pylons will not be allowed.<br>" +
                "All connections are to be made using nuts and bolts of suitable dimension.<br>" +
                "The bridge should be self-supported, no support will be provided from the sides."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* The testing will be done under the strict supervision of the judges. The best design of bridge will be selected on the basis of three main testing criteria.<br>" +
                "* The participants have to give a presentation on the structural aspects of their bridge.<br>" +
                "* The presentation must include the behaviour of the bridge under the loading conditions. The presentation weighs 15% of the total score.<br>" +
                "* The bridge will be loaded with a dead load.<br>" +
                "* The loading will start with a minimum weight of 10 kg and will be continued till it reaches the maximum deflection of 60 mm.<br>" +
                "* Then the ratio of the maximum load carried by the bridge to the weight of the bridge (excluding the weight of plywood base and L-clamps) will be considered.<br>" +
                "* Finally the bridge is loaded till destruction and the ultimate load is noted. This criterion carries a weightage of 85%."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Palash Nigam</b><br>" +
                "nigam.palash@gmail.com<br>" +
                "+91-80152 02289<br><br>" +
                "<b>Soumyajit Paul</b><br>" +
                "soumyajit.paul05@gmail.com<br>" +
                "+91-99629 48985<br><br>" +
                "<b>Magraj Gehlot</b><br>" +
                "mag_raj@srmuniv.edu.in<br>" +
                "+91-90802 75922<br><br>" +
                "<b>Aakash Srivastava</b><br>" +
                "srivastava.aakash@ymail.com<br>" +
                "+91-99622 45708"));
    }

}