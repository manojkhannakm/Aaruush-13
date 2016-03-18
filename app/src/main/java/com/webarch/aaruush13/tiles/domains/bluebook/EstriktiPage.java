package com.webarch.aaruush13.tiles.domains.bluebook;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class EstriktiPage extends EventPage {

    public EstriktiPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("Estrikiti is an entirely fun based event which reflects on the basics of structures and compositions that we tend to ignore generally. " + "It will test the core basic knowledge of participants.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "This event reflects on the basics of structures and compositions of substances used in daily life that are ignored generally and their applications. " + "Estrikiti is thus, an event which tests ones basics in a very casual manner and ensures the participant loads of fun along with knowledge.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - DIGRAMA(5 MINUTES)</b><br>" +
                "Cartoonish diagrams of chemical and biological aspects of life will be given to the participants along with a word problem. " +
                "They have to puzzle it out & mention three key words related to it(10 questions).<br><br>" +
                "<b>Round 2 - Burning Brains</b><br>" +
                "A short clip related to a very common thing that we do will be shown and group discussion will be held related to the topic of clip.<br><br>" +
                "<b>Round 3 - MAD LABS</b><br>" +
                "<b>Level 1</b><br>" +
                "It is a totally practical oriented round. A set of experiment's are performed. " +
                "All the participants will be provided with whole procedure and observation and they are expected to infer accordingly. " +
                "It includes brainy fun based games.(\"scribble it up\")<br>" +
                "<b>Level 2</b><br>" +
                "It is a rapid fire round based on the general knowledge about a experiment and the scrabble puzzle."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Manika Mongia</b><br>" +
                "monga.manika@yahoo.com<br>" +
                "+91-99401 24981<br><br>" +
                "<b>Pooja Singh</b><br>" +
                "poojasur22@gmail.com<br>" +
                "+91-80560 34269<br><br>" +
                "<b>Deepak Karunakaran</b><br>" +
                "deepak.z.karunakaran@gmail.com<br>" +
                "+91-89393 89434"));
    }

}