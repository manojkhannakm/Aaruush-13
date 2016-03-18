package com.webarch.aaruush13.tiles.domains.robogyan;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class MazeOSoccerPage extends EventPage {

    public MazeOSoccerPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("The event is a test of all the important skill sets that a bot can contain, ranging from flexibility to mobility and endurance. " +
                "The first round which is in a maze will see the speed and control tested. " +
                "The second round will see the same skills tested along with a really challenging terrain and asking questions of the bot as well as the user. " +
                "The final round will be a one on one football match where the bots go head to head, to showcase their footballing skills.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "The aim is to relive the life of a footballer in a bot's outfit. " + "The strive towards achieving a proper status of a professional player is reflected by the level of difficulties which he has to pass through.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - The dream begins</b><br>" +
                "The life of the bot begins as he aspires to become a top flight footballer, and he starts his trials and gets through the selections by showing his skills and passing through a difficult maze. " +
                "The objective of this round will be to pass through different defined checkpoints and reach the centre of the maze.<br><br>" +
                "<b>Round 2 - Living the dream</b><br>" +
                "In this round of the event, the bot is supposed to be a player who is practicing before the match and hence is working out all endurance exercises. " +
                "The bot has to solve the maze again, but in a really more challenging terrain along with carrying different balls to given checkpoints. " +
                "Each ball taken home has different number of points according to the difficulty.<br><br>" +
                "<b>Round 3 - Taking on the world</b><br>" +
                "This will be the finale of the event where the bots will take on one another in an enthralling football match which will see them hustling for the ball and scoring and saving. " +
                "The team with the highest number of goals and the end of stipulated time will be adjudged the winner."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Each team should have a participant count of 2-5.<br>" +
                "* Dimensions of the bot should not exceed :30*25*20(cm).<br>" +
                "* Points will be reduced if the bot goes out of bounds or stops functioning in the middle of the rounds.<br>" +
                "* Bots once placed in the field, can only be touched twice if malfunctioned, that too after deduction of points and if any further delay occurs, the participant will be disqualified.<br>" +
                "* The user cannot touch the boundaries or move in while controlling the bots."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Aviral Janveja</b><br>" +
                "aviralcr79@gmail.com<br>" +
                "+91-87545 66426<br><br>" +
                "<b>Chandan A</b><br>" +
                "chandanblaze@gmail.com<br>" +
                "+91-95000 51830<br><br>" +
                "<b>Navneeth Thakur</b><br>" +
                "thakurnavneet@hotmail.com<br>" +
                "+91-80562 09064<br><br>" +
                "<b>Shubham Thaakker</b><br>" +
                "shubamthakker@gmail.com<br>" +
                "+91-99629 40670"));
    }

}