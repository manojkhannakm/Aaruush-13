package com.webarch.aaruush13.tiles.domains.specials;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class RobothonPage extends EventPage {

    public RobothonPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("To Design and construct a wired or wireless manual robot capable of racing and withstanding uneven terrain while competing against other robots cracking its way through the arena on land and/or water will be the challenge. " + "The robot should be designed and cost kept in mind such that when placed in an Expo, its only aim is to rise as 'The Unbeatable and Most Innovative Robot' will test your skills.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "To Design and construct a wired or wireless manual robot capable of racing and withstanding uneven terrain while competing against other robots cracking its way through the arena on land and/or water will be the challenge. " + "The robot should be designed and cost kept in mind such that when placed in an Expo, its only aim is to rise as 'The Unbeatable and Most Innovative Robot' will test your skills.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Water Based</b><br>" +
                "<b>Event - Points - Parameter</b><br>" +
                "Static - 100 - Cost, Design<br>" +
                "Dynamice - 300 - Moving an object from one point to another in the shortest time. - 300 Points, One-on-one Arena fight to push the other robot beyond a particular margin boundary or into a pit. - 300 Points, Timed drag race - 300 Points<br><br>" +
                "<b>Land Based</b><br>" +
                "<b>Event - Points - Parameter</b><br>" +
                "Static - 100 - Cost, Design<br>" +
                "Dynamice - 300 - Arena Race (Category wise) - 300 Points, One-on-one Arena fight to push the other robot beyond a particular margin boundary or into a pit. (Category wise) - 300 Points, Timed circuit race (Common) - 300 Points<br><br>" +
                "<b>Total Points - 1000</b><br><br>" +
                "For the Expo, The Best Voted Robot prize will be awarded to the Robot having the maximum number of votes. The Expo will remain open on all 4 days, out of which 3 days will consist of General Voting by spectators. The 4th Day will consist of Votes given by invited Members who will be experts in their respective fields. The Votes given by invited Members carry double the weightage of a vote cast by a spectator.<br><br>" +
                "<b>Prizes to be Won</b><br>" +
                "First Prize - Land Based<br>" +
                "Second Prize - Land Based<br>" +
                "First Prize - Water Based<br>" +
                "Second Prize - Water Based<br>" +
                "Best Voted Robot<br><br>" +
                "Note: The Rules may be subject to change without prior information. Although utmost care will be taken to inform participants well ahead, no member of the Organising Committee, the Coordinators of the event or Aaruush may be held accountable. Rules will be clarified clearly before the start of the event."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Each team can have maximum of 4 members and Match duration is 5 minutes.<br>" +
                "* During the match only three team-members will participate in competition (active members), one member will control the robot and the other member will control the arena weapons (power lifter)and the third will manage the (crusher). Teams are allowed to switch the active members in different matches.<br>" +
                "Note: This switch is not allowed in the middle of an on-going match.<br>" +
                "* Setup time of 60 seconds will be given. In case a team is not able to report to the weight and measurement counter before their setup time starts, then the opponents will be declared as the winners of that round.<br>" +
                "* Also, if a team fails to setup their robot within 120 seconds, then the opponents will be given a walk-over.<br>" +
                "* If the robot operator is seen to be using the wire from the controller to pull, move or hold the robot, i.e. if the wire becomes taught at any point, the team will be disqualified.All efforts must be made to protect battery terminals from a direct short and causing a battery fire, failure to do so will lead to direct disqualification.<br>" +
                "* A robot is declared immortal/ victorious if its opponent becomes totally inactive. A robot will be declared as inactive if it cannot display any movement for a time period of 30 seconds."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Aditya Tandon</b><br>" +
                "Email: adityatandon2006@gmail.com<br>" +
                "+91-80560 08433<br><br>" +
                "<b>Aditya Rai</b><br>" +
                "Email: adityuarai_home@gmail.com<br>" +
                "+91-80560 06843<br><br>" +
                "<b>Ankit Vajpai</b><br>" +
                "Email: ankit1993vajpai@yahoo.com<br>" +
                "+91-90437 18869<br><br>" +
                "<b>Aadi Mishra</b><br>" +
                "aadinathan21@in.com<br>" +
                "+91-99620 67333"));
    }

}