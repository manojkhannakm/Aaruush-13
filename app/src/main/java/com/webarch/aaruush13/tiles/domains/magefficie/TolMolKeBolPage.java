package com.webarch.aaruush13.tiles.domains.magefficie;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class TolMolKeBolPage extends EventPage {

    public TolMolKeBolPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("The event Tol Mol Ke Bol focuses on flexible thinking of a person starting from making a normal living in a budget to ignite big ideas like business management. " + "It makes you enjoy the essence of entrepreneurship and makes the participant explore new possibilities in their respective fields.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "The event Tol Mol Ke Bol focuses on flexible thinking of a person starting from making a normal living in a budget to ignite big ideas like business management. " + "It makes you enjoy the essence of entrepreneurship and makes the participant explore new possibilities in their respective fields.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Bid your Zone</b><br>" +
                "In this round,each team will bid for their land,contractor and marketing group from the list of best special economic zones,contractors and marketing group using the given hypothetical money.<br><br>" +
                "<b>Round 2 - Market it now</b><br>" +
                "Now the teams qualifying the 1st round are assumed to have set up an industry. The team will have to select the raw materials required for the product from a given hypothetical raw material list.the materials will be bought from the money saved in round 1.<br><br>" +
                "<b>Round 3 - Krysis</b><br>" +
                "This round checks the participant's crisis management skills. Each team will be given a crisis depending on their products. And team has to resolve it.<br><br>" +
                "<b>Round 4 - The Massive Mashup</b><br>" +
                "The finalised teams have to reach out the public and sell out their product.they will have to sell the maximum number of products in a limited time."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Number of participants per team: 2<br>" +
                "* The decisions of the organizers of the contest and the panel of judges will be final and binding on all the participants.<br>" +
                "* The terms and conditions of the participation are subject to change at any time without prior notice. The amended terms and conditions of entry will be effective immediately upon being posted on the website. It is the sole responsibility of the teams to regularly visit the website and Aaruush facebook page to read any changes.<br>" +
                "* Presentation language must be only in English.<br>" +
                "* Participants are forbidden from using foul language, racist idea or any other material that may be offensive to any community.<br>" +
                "* Disobedience of rules will lead to immediate elimination."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Ankita Abhimanyu Tangade</b><br>" +
                "+91-87545 00318<br>" +
                "ankitatangade@yahoo.com<br><br>" +
                "<b>Bhargav Sai</b><br>" +
                "+91-81227 11482<br>" +
                "bhargavmella@gmail.com<br><br>" +
                "<b>Palash Khandelwal</b><br>" +
                "+91-81223 09927<br>" +
                "khandelwalpalash8@gmail.com<br><br>" +
                "<b>Abhirupa Lodh</b><br>" +
                "+91-80560 32693<br>" +
                "abhirupalodh@gmail.com"));
    }

}