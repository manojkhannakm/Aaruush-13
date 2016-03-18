package com.webarch.aaruush13.tiles.domains.yuddhame;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class SaveTheQueenPage extends EventPage {

    public SaveTheQueenPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Digital gates are something of a monotonous subject... " +
                "But worry not! This event showcases the concepts of digital gates and C/C++ programming in a way never seen before. " +
                "This event will take you back to your basics and encourage you to strategize and think beyond your boundaries, thus inculcating the theme of Aaruush - Towards Infinity. " +
                "It's an event of its own kind and it will keep you engrossed. " +
                "You will never view logic gates and programming in the same way. " +
                "So join the quest to \"save the queen\"!!!");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Digital gates are something of a monotonous subject... " +
                "But worry not! This event showcases the concepts of digital gates and C/C++ programming in a way never seen before. " +
                "This event will take you back to your basics and encourage you to strategize and think beyond your boundaries, thus inculcating the theme of Aaruush - Towards Infinity. " +
                "It's an event of its own kind and it will keep you engrossed. " +
                "You will never view logic gates and programming in the same way. " +
                "So join the quest to \"save the queen\"!!!");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Technology towards Infinity</b><br>" +
                "This round will consist of an aptitude test in which the participants will be tested on their basic computer knowledge like company logos, abbreviations, generation of computers etc in a creative design.<br><br>" +
                "<b>Round 2 - Time and Tide Wait For None</b><br>" +
                "In this round, one of the team members will be solving 15 questions involving digital gates and the other member will be separately performing 15 simple and basic C/C++/Java programs. Both will have to solve the questions within a certain time limit. The team member who completes his/her respective task first, will be providing extra time to the other member to finish his/her task. In case both team members complete their respective tasks within their time, their saved time will be added in the next set of questions.<br><br>" +
                "<b>Round 3 - Mind your luck</b><br>" +
                "It is a board game based on both luck and presence of mind. This game will be played between 4 teams. The 4 teams will start from each corner of the board and travel to the centre. The borders of the board will have a sequence of functions and programs which are to be solved. If the participants get a \"true\" value as an output, their pawn will move a step in status ladder (A in Board-game) otherwise their pawn will go back. There will be some surprise elements provided on the diagonal path A which will act as ladders for the team to reach their goal in shorter time, which if used tactfully will help them climb the ladder and thus, jump some steps ahead. The team which reaches the destination first (Circle), wins.<br><br>" +
                "<b>Round 4 - Battle Blitz</b><br>" +
                "In this round, the teams will be given a logic gate maze. One of the team members will solve the gate maze with 0'sand 1's (truth tables) and find the correct path that leads to the clue. The clue will lead the second member to the final program which is to be coded in C/C++/Java and hence find the queen…"));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Team must be of 2 members.<br>" +
                "* In final round i.e. Round 4, only final 8 teams will be qualified.<br>" +
                "* Stick to the time limit.<br>" +
                "* No calculators or truth tables allowed."));

        eventCollapsibleView.addPanel("FAQ", Html.fromHtml("<b>Should I be an expert in programming?</b><br>" +
                "Only preliminary programming knowledge is more than enough.<br><br>" +
                "<b>What about Logic Gates?</b><br>" +
                "Participants will be given instruction sheets that helps them to solve logic gates via e-mails.<br><br>" +
                "<b>Why should I participate?</b><br>" +
                "All because fun just reached a new level. We promise that you won't be bored, even for a minute. The queen will laden her saviors with her treasures."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Akshit Dua</b><br>" +
                "akshit_dua@srmuniv.edu.in<br>" +
                "+91-99626 18359<br><br>" +
                "<b>S.Nivetha</b><br>" +
                "nivetha18@gmail.com<br>" +
                "+91-97909 77796<br><br>" +
                "<b>Anusha Vajjala</b><br>" +
                "anusha_vajjala@yahoo.co.in<br>" +
                "+91-99629 39094<br><br>" +
                "<b>Vartika Agarwal</b><br>" +
                "vartika.28393@gmail.com<br>" +
                "+91-97910 60347"));
    }

}