package com.webarch.aaruush13.tiles.domains.magefficie;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class CorporateChanakyaPage extends EventPage {

    public CorporateChanakyaPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Do you have it in you to be the HR MANAGER of a company? Come and figure out the HR world at AARUUSH'13 with CORPORATE CHANAKYA EVENT." + "This event aims at bringing out the HR MANAGER side in you.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Do you have it in you to be the HR MANAGER of a company? Come and figure out the HR world at AARUUSH'13 with CORPORATE CHANAKYA EVENT." + "This event aims at bringing out the HR MANAGER side in you.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "Tap the HR manager in you as you are exposed to a series of possible crisis. Choose the response that you would give for these crises.<br><br>" +
                "<b>Round 2</b><br>" +
                "This round basically has three events. The participants would be randomly allotted any one of the three events<br>" +
                "Event 1: in this event the participants would be required to make a presentation that motivates the freshers in the company<br>" +
                "Event 2: in this event the participants would be required to address a crisis in a board meeting and come up with a possible solution<br>" +
                "Event 3: in this event the participants would be required to prepare a schedule for a moth with a set of given activities included in it.<br><br>" +
                "<b>Round 3</b><br>" +
                "Now the best participants from the previous round would proceed to the next round. This round is again divided into two parts interview and recruit.<br>" +
                "Interview: now the participants would undergo an interview process from which based on their performance the top candidates would move on to the next part of this round.<br>" +
                "Recruit: Here the participants would be required to interview a few candidates, select some of them for a given post. Later a work report of the candidate would be given to them to which they must react suitably."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Number of participants per team: 2<br>" +
                "* The decisions of the organizers of the contest and the panel of judges will be final and binding on all the participants.<br>" +
                "* The terms and conditions of the participation are subject to change at any time without prior notice. The amended terms and conditions of entry will be effective immediately upon being posted on the website. It is the sole responsibility of the teams to regularly visit the website and Aaruush facebook page to read any changes.<br>" +
                "* Presentation language must be only in English.<br>" +
                "* Participants are forbidden from using foul language, racist idea or any other material that may be offensive to any community.<br>" +
                "* Disobedience of rules will lead to immediate elimination."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Padmavathi Venkatesh</b><br>" +
                "padmavathivenkatesh@gmail.com<br>" +
                "+91-95006 89870<br><br>" +
                "<b>Suhasini</b><br>" +
                "hasini_8201@gmail.com<br>" +
                "+91-97908 41273"));
    }

}