package com.webarch.aaruush13.tiles.domains.specials;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class BellTheBullPage extends EventPage {

    public BellTheBullPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("For all business minds waiting to show their business skills and corporate strategies, bell the bull is the chance to showcase their mettle. " +
                "This event takes you to the heart of the crucible of business that is, the Stock Exchange. " +
                "Your task is to trade stocks in a Virtual Stock Market.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "For all business minds waiting to show their business skills and corporate strategies, bell the bull is the chance to showcase their mettle. " +
                "This event takes you to the heart of the crucible of business that is, the Stock Exchange. " +
                "Your task is to trade stocks in a Virtual Stock Market.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("1. There is only one round in the event which will be played 3 times a day, each round being 2.5-3 hrs long. The event will run for all the 4 days of AARUUSH.<br>" +
                "2. A participant can participate more than one time.<br>" +
                "3. All participants will be given a starting investment. A list of 25-30 companies from various industries will be available for them whose stocks they have to buy/sell.<br>" +
                "4. Through the course of the event clues will be announced like newsflashes and experts advice. The participants will have to anticipate the repercussions.<br>" +
                "5. Participants will be given a history card containing history of all the companies , which they may use as reference during the course of the event.<br>" +
                "6. The stock prices as well as the newsflashes will be displayed on a screen continuously.<br>" +
                "7. Apart from this there will be volunteers handing out 'newspapers'. The news center will be responsible for handing out these newspapers, also they will make occasional announcements regarding certain 'breaking news'.<br>" +
                "8. Participants will have to pay attention to these headlines as they are clues as to how will the stock prices change.<br>" +
                "9. The winner is the participant who manages to make the maximum amount of money, using their managerial skills, abilities under pressure and investment skills."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* Each participant has to invest a certain amount of money initially in the first 20 minutes.<br>" +
                "* They are allowed to use only the virtual money.<br>" +
                "* Decorum has to be maintained while buying and selling the shares from the counter.<br>" +
                "* Malpractice on the balance sheet will not be tolerated.<br>" +
                "* Participants have to use the balanced sheets given by us."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Anand Garg</b><br>" +
                "anandgarg1994@gmail.com<br>" +
                "+91-97899 98273<br><br>" +
                "<b>Annette Francis Parakkal</b><br>" +
                "annettemareen@yahoo.com<br>" +
                "+91-99400 27646"));
    }

}