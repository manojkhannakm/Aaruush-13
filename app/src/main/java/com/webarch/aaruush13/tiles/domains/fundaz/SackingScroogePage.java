package com.webarch.aaruush13.tiles.domains.fundaz;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class SackingScroogePage extends EventPage {

    public SackingScroogePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Money is something that no one can say no to. " +
                "Since this is a money related event, we bet no one can resist from joining this event. " +
                "This event tries to make the participants aware about the various currencies and logos across the globe. " +
                "It aims at giving a basic idea about money management and to work out things with their abilities and management skills.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Money is something that no one can say no to. " +
                "Since this is a money related event, we bet no one can resist from joining this event. " +
                "This event tries to make the participants aware about the various currencies and logos across the globe. " +
                "It aims at giving a basic idea about money management and to work out things with their abilities and management skills.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Mining Coins</b><br>" +
                "This round consists of 15 questions based on aptitude and logical reasoning. " +
                "The participants will be given 25 minutes to solve the quiz.<br><br>" +
                "<b>Round 2 - Mysterious Maze</b><br>" +
                "In this round, teams will be given a maze to solve. " +
                "The maze will have partially visible logos of famous companies at every turn. " +
                "Teams will have to devise a way to solve the maze and at the same time collect maximum number of logos.<br><br>" +
                "<b>Round 3 - Bid To Win</b><br>" +
                "This is the final round and is a quiz round. " +
                "Finalists will bid for the questions and the highest bidder gets to answer the question and earn money. " +
                "Participants can also use the money earned so far in the bidding if they fall short of money. " +
                "The one with the highest number of coins in the end and clears FUNDAZ wins."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Abhijeet Karla</b><br>" +
                "Abhijeet.mithu.kalra@gmail.com<br>" +
                "+91-99629 40479<br><br>" +
                "<b>Anshul Nalin</b><br>" +
                "Anshul2nailin@gmail.com<br>" +
                "+91-98409 44597<br><br>" +
                "<b>Onam Sharma</b><br>" +
                "Onamsharma9@yahoo.com<br>" +
                "+91-87545 36409<br><br>" +
                "<b>Avdhesh Juneja</b><br>" +
                "avij1806@gmail.com<br>" +
                "+91-90255 73332"));
    }

}