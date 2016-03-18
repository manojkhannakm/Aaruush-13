package com.webarch.aaruush13.tiles.domains.magefficie;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class SuccessSutraPage extends EventPage {

    public SuccessSutraPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Dust Entire Business World off with your Talent. " +
                "Here we are looking for the \"Metals\" whose \"Motto\" is for the \"Manifestation\" of new thoughts and innovative ideas in the rapidly emerging business world. " +
                "Come and showcase your talent on a platform where your thoughts get direction and form in the end. " +
                "Come indulge answer simple questions with alacrity.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Dust Entire Business World off with your Talent. " +
                "What are you looking for??? Here we are looking for the \"Metals\" whose \"Motto\" is for the \"Manifestation\" of new thoughts and innovative ideas in the rapidly emerging business world. " +
                "Come and showcase your talent on a global platform where your thoughts get Fruitful at the end. " +
                "How to indulge???? Its simple and easy. " +
                "Just answer to simple questions with alacrity. " +
                "Life without a challenge is worthless. So we provide you the strategies, face it with courage and end up with joy. " +
                "Everywhere the business is online today so ready to show your own interface with the internet. " +
                "The real business person in you will be examined through some strategies. " +
                "So come up with the challenge and cope up to the strategies and possess the feeling of real entrepreneur in this BUSY BUSINESS WORLD.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - B-QUIZ</b><br>" +
                "Every participant in this will be given some questions to answer and evaluation will be done accordingly.<br>" +
                "The points will be carried to the next rounds.<br><br>" +
                "<b>Round 2 - B-NET</b><br>" +
                "URL of a company will be given.<br>" +
                "Limited number of clicks will be provided, using those make the business strategy of that company.<br>" +
                "You can buy the extra clicks from the B-quiz points.<br>" +
                "The participants after refinement of Round-2 will be promoted to Round-3.<br><br>" +
                "<b>Round 3 - B-KING</b><br>" +
                "A product will be provided.<br>" +
                "Make out the best strategies to marketise the product and to enhance its selling in the market to ahuge extent.<br>" +
                "The criteria of evaluation and also the right of decision will be completely given to the judges.<br>" +
                "The maximum points earned participant will be the SUCCESS SUTRA winner."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Number of participants per team: 2<br>" +
                "* The decisions of the organizers of the contest and the panel of judges will be final and binding on all the participants.<br>" +
                "* The terms and conditions of the participation are subject to change at any time without prior notice. The amended terms and conditions of entry will be effective immediately upon being posted on the website. It is the sole responsibility of the teams to regularly visit the website and Aaruush facebook page to read any changes.<br>" +
                "* Presentation language must be only in English.<br>" +
                "* Participants are forbidden from using foul language, racist idea or any other material that may be offensive to any community.<br>" +
                "* Disobedience of rules will lead to immediate elimination."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Jayanth Reddy</b><br>" +
                "jayanthreddy4u@gmail.com<br>" +
                "+91-99621 58797<br><br>" +
                "<b>K. Anvesh Sameer</b><br>" +
                "kausuma_anvesh@srmuniv.edu.in<br>" +
                "+91-98498 54162"));
    }

}