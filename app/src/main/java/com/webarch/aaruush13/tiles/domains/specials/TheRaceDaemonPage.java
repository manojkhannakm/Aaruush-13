package com.webarch.aaruush13.tiles.domains.specials;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class TheRaceDaemonPage extends EventPage {

    public TheRaceDaemonPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Participants have to design and fabricate a RC race buggy powered by an IC engine which can compete in hurdles and speed rounds flawlessly.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "Participants have to design and fabricate a RC race buggy powered by an IC engine which can compete in hurdles and speed rounds flawlessly.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("Max 4 member per team<br><br>" +
                "<b>Round 1 - The Wheelie Challenge</b><br>" +
                "Every car needs to perform a wheelie and is awarded points accordingly (longer the wheelie, more the number of points)<br><br>" +
                "<b>Round 2 - Got The Speed</b><br>" +
                "The first round is best timing round. The driver recording the minimum time in finishing 2 laps of the circuit wins.<br><br>" +
                "<b>Round 3 - Got The Wings</b><br>" +
                "A short runway and an inclined ramp. All that needs to be done is accelerate and make the big jump .The longest jump wins.<br><br>" +
                "<b>Round 4 -Endurance</b><br>" +
                "The final round is the circuit round on the track having various hurdles and resistances."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* All results declared would be final and will not be altered.<br>" +
                "* Going out of the track during round 1 and 3 will result in disqualification.<br>" +
                "* Violence between buggies on tracks is not allowed."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Kabir Jain</b><br>" +
                "jain_kabir_11@yahoo.co.in<br>" +
                "+91-80151 86885<br><br>" +
                "<b>Vipul Sachdev</b><br>" +
                "vipul992sachdev@gmail.com<br>" +
                "+91-99529 50657<br><br>" +
                "<b>Bhargava Daita</b><br>" +
                "daitabhargava@gmail.com<br>" +
                "+91-80152 74065<br><br>" +
                "<b>Pooja Dwivedi</b><br>" +
                "hellblazor@gmail.com<br>" +
                "+91-99402 15309"));
    }

}