package com.webarch.aaruush13.tiles.domains.fundaz;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class XploraPage extends EventPage {

    public XploraPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("A science adventure game that tests your basics in science, technology and general knowledge! A plane crashes on an isolated island, in a remote region. " +
                "You are one of the few survivors. " +
                "There is a ship on its other side, which seems to be the only way to get back and to reach it one has to cross the island which is the condominium of a few mysterious inhabitants, who put you through various tests. " +
                "There are four major parts to cross to reach the other side of the island, namely the shore, the cave, the barren field and the shore on the other side.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "A science adventure game that tests your basics in science, technology and general knowledge! A plane crashes on an isolated island, in a remote region. " +
                "You are one of the few survivors. " +
                "There is a ship on its other side, which seems to be the only way to get back and to reach it one has to cross the island which is the condominium of a few mysterious inhabitants, who put you through various tests. " +
                "There are four major parts to cross to reach the other side of the island, namely the shore, the cave, the barren field and the shore on the other side.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Puzzle-Namia</b><br>" +
                "This is the preliminary round. " +
                "The participant will be provided with JIG-SAW puzzles, which he/she is required to solve, to get their question. " +
                "The question is then to be answered correctly.<br><br>" +
                "<b>Round 2 - Face-o-logy</b><br>" +
                "The participant will have to navigate from the start to the end of a board and answer questions corresponding to the picture, based on their position on it. " +
                "The board consists of numbered gridded squares, and their positions will be decided by a pointer.<br><br>" +
                "<b>Round 3 - Break-D-Grid</b><br>" +
                "The participant will be divided into two teams X and O based on his/her performance so far. " +
                "A screen with a grid similar to that of Tic-Tac-Toe will be displayed and he/she will have to play a classic game of X-O and win it to unlock their question to which they will have to give the right answer.<br><br>" +
                "<b>Round 4 - En Finale</b><br>" +
                "It consists of two sub-rounds<br>" +
                "<b>Hangover Finale</b><br>" +
                "The participant is expected to conduct a scientific experiment/ use his/her basics to solve some practical problems. " +
                "For each wrong step he takes, he loses the ability to use one part of the body for the rest of the game. " +
                "(e.g. a participant may be unable to use his/her left hand throughout the experiment). " +
                "If the participant is unable to do all the questions, he is hung i.e. he wouldn't be moving on to the second round.<br>" +
                "<b>Scientific casino</b><br>" +
                "Top 6 participants will be selected into this half. " +
                "The participant has to bet his/her points with the inhabitants and perform tasks corresponding to the number they get when the wheel rotates and the gambolling begins."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Vinay</b><br>" +
                "vinay_iamgood@yahoo.co.in<br>" +
                "+91-98409 46893<br><br>" +
                "<b>Raikesh</b><br>" +
                "das.rakesh1994@gmail.com<br>" +
                "+91-99413 67458<br><br>" +
                "<b>Manasa</b><br>" +
                "manasa.prakash@hotmail.com<br>" +
                "+91-97907 66142<br><br>" +
                "<b>Yashashwy</b><br>" +
                "yashaswisrinivas@yahoo.in<br>" +
                "+91-95000 26713"));
    }

}