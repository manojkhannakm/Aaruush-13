package com.webarch.aaruush13.tiles.domains.konstruktion;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class AngryRocketsPage extends EventPage {

    public AngryRocketsPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("To make hydro rockets of your freedom and destroy your target with provided armed launcher. " + "(concept: angry birds)");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Based on the concept of the popular android game \"Angry birds\", this event allows you to make hydro rockets of your freedom and destroy your target with the provided armed launcher.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1: Strike the Infinity</b><br>" +
                "In this round the teams are required to hit the Bull's eye. " +
                "From here the top 70% will proceed to the next round.<br><br>" +
                "<b>Round 2: Power Strike</b><br>" +
                "In this round teams will be asked to hit a little complicated target on which points will be kept of two different values. " +
                "They have to use 3 rockets and can get 5 bonus points per rocket saved. " +
                "From here top 5 teams will go to next and final round.<br><br>" +
                "<b>Round 3: Covert Strike</b><br>" +
                "In this round target would be hidden from the teams; a curtain will be placed in front of the participants and teams have to hit over it to reach the target. " +
                "Teams will be allowed to examine the target before they proceed with their launch. " +
                "Points will be same as in Round 2."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* No multistage rockets are allowed.<br>" +
                "* Only 2 litre water bottles can be used.<br>" +
                "* Teams can go for backup rockets only after they have been examined by core team.<br>" +
                "* Scores will be evaluated by the core team.<br>" +
                "* Core team decision will be final.<br>" +
                "* Any team getting into argument with the core team can be disqualified."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Amanjot Singh</b><br>" +
                "als_ajs02@yahoo.co.in<br>" +
                "+91-98845 69251<br><br>" +
                "<b>Chaitanya Mayekar</b><br>" +
                "33rdvirus@gmail.com<br>" +
                "+91-81442 91281<br><br>" +
                "<b>Chetan Dekate</b><br>" +
                "crdekate@gmail.com<br>" +
                "+91-98846 84816<br><br>" +
                "<b>Harsh Chaturvedi</b><br>" +
                "harshchaturvedi10@gmail.com<br>" +
                "+91-89395 88204"));
    }

}