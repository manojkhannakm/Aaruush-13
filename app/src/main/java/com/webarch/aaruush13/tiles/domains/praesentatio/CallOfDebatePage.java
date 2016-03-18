package com.webarch.aaruush13.tiles.domains.praesentatio;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class CallOfDebatePage extends EventPage {

    public CallOfDebatePage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("An event for all those who are ready to speak their mind out, frankly. " + "The mind boggling topics which will take the participants on a not yet explored journey, swirling them in a farrago of emotions and ideas leading them towards a new level...aiming the infinite.");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "An event for all those who are ready to speak their mind out, frankly. " + "The mind boggling topics which will take the participants on a not yet explored journey, swirling them in a farrago of emotions and ideas leading them towards a new level...aiming the infinite.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - The Bait</b><br>" +
                "\"There is no true orator who is not a hero\"<br>" +
                "The first round of the event will aim at testing the oratory skills of the participant. " +
                "From the pool of topics which will be related to technology and management, each participant would be assigned a specific topic after which, he/she will be provided with 30 seconds of preparation time to think over the topic, following which the participants will have to express their views on the same within a stipulated time span of 2 minutes.<br><br>" +
                "<b>Round 2 - Turncoat</b><br>" +
                "The second round will examine the adaptability and sharpness of the participants. " +
                "It is quite similar to \"Block and Tackle\". " +
                "This round brings with it a bit of twist wherein the participant will be asked express their views in 'favour' and 'against' the topic in a multiple fashion.<br><br>" +
                "<b>Round 3 - Historical GD</b><br>" +
                "In this round the participants will be divided into groups & each group will be given a true life situation. " +
                "Each member of the group will be allocated a character. " +
                "The character would be closely related to the situation. " +
                "Participants need to melt into the character and react, debate and take decisions accordingly.<br><br>" +
                "<b>Round 4 - Differential Timeline</b><br>" +
                "In this round the short listed participants would be given a technical subject. " +
                "Then they would be thrown back or forward in the timeline where they would have to pose as they are in that century or decade and speak on how the given subject was/would be during that timeline.<br><br>" +
                "<b>Round 5 - The Verbal Warfare</b><br>" +
                "The finalised 8 best participants from round 4 will be divided into 4 teams and will be asked to debate upon in a BRITISH PARLIAMENTARY format, which will be followed by a grand finale of the final 2 participants to win the final battle of debating."));

        eventCollapsibleView.addPanel("Rules", Html.fromHtml("* No use of any outside sources(including internet and books)<br>" +
                "* Time limit should be taken into consideration.<br>" +
                "* The judge's decision will be final and binding.<br>" +
                "* The coordinators reserve the right to expel any participant at any stage if found guilty of the code of conduct."));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Dhairya Phatak</b><br>" +
                "rockstardhairya@gamil.com<br>" +
                "+91-99401 54971<br><br>" +
                "<b>Rohit Gadia</b><br>" +
                "rohitgadia.95@gmail.com<br>" +
                "+91-87544 25594"));
    }

}