package com.webarch.aaruush13.tiles.domains.magefficie;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class MarketMayhemPage extends EventPage {

    public MarketMayhemPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("For all you aspiring AD GURUS out there, THIS is the place to be. " +
                "Make and present your advertisements and test how whacky and attractive your ideas are. " +
                "Come and be a part of this ad-a-ganza.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "For all you aspiring AD GURUS out there, THIS is the place to be. " +
                "Make and present your advertisements and test how whacky and attractive your ideas are. " +
                "Come and be a part of this ad-a-ganza.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Mad with ad</b><br>" +
                "The first round \"Mad with ad\" is where the participants are provided with a few advertisements which are altered in such a way that the merchandise or the service which is being advertised is clipped out at the end .The round requires the participants to guess the merchandise or product being advertised. Teams with maximum number of correct guesses would proceed to the next round. AAKASH tablets shall be used for conduction of this round.<br><br>" +
                "<b>Dumbness</b><br>" +
                "As for the second round, the participants are required to guess the word which Is being enacted by their team member . The topic could be movies ,things etc. This round is basically Dumb charades.<br><br>" +
                "<b>Adzap</b><br>" +
                "The third round \"Adzap\" requires the participants to be spontaneous and creative. The participants are to come up with ideas and act out a product given to them. The topic will be given on the spot.<br><br>" +
                "<b>Presentation</b><br>" +
                "The fourth round \"Presentation\" is where the participants are to think of ways and means of how a product can be best brought into today's market, given a few limitations. This round is to test the participant's presentation skills and the strategy they adopt for establishing a market for their product. This round will be evaluated by a panel of judges."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Number of participants per team: 2<br>" +
                "* The decisions of the organizers of the contest and the panel of judges will be final and binding on all the participants.<br>" +
                "* The terms and conditions of the participation are subject to change at any time without prior notice. The amended terms and conditions of entry will be effective immediately upon being posted on the website. It is the sole responsibility of the teams to regularly visit the website and Aaruush facebook page to read any changes.<br>" +
                "* Presentation language must be English.<br>" +
                "* Participants are forbidden from using foul language, racist idea or any other material that may be offensive to any community.<br>" +
                "* Disobedience of rules will lead to immediate elimination."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>B. Raghunandan</b><br>" +
                "yamaha.7882@gmail.com<br>" +
                "+91-90031 87976<br><br>" +
                "<b>Raja T. E.</b><br>" +
                "rajate1992@gmail.com<br>" +
                "+91-78452 95682<br><br>" +
                "<b>Prince Michale</b><br>" +
                "prince.michale15@gmail.com<br>" +
                "+91-96771 58755<br><br>" +
                "<b>Praveen</b><br>" +
                "praveen46@gmail.com<br>" +
                "+91-99403 72293"));
    }

}