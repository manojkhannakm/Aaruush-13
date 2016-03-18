package com.webarch.aaruush13.tiles.domains.praesentatio;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class JAMPage extends EventPage {

    public JAMPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("You have seen. " +
                "You have heard. " +
                "Now, come witness! " +
                "You have one minute to prove your point, to disprove everyone else's and to defy the divine hand of GOD(politely). " +
                "The Queen prefers that her English be spoken. " +
                "Coherence is appreciated, but if you are slow to speak, then at least be sure to start off with a bang! JAM MOD IS GOD!!");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "You have one minute to prove your point, to disprove everyone else's and to defy the divine hand of GOD(politely). " +
                "The Queen prefers that her English be spoken. " +
                "Coherence is appreciated, but if you are slow to speak, then at least be sure to start off with a bang.");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1 - Just-a-minute</b><br>" +
                "Participants will be divided into groups. " +
                "Each group will be provided a particular topic on the spot. " +
                "60seconds will be given to the group to think about the topic given. " +
                "Immediately after 60 seconds, the discussion will start and 3 minutes time will be provided to discuss over the topic and objections be made. " +
                "The MOD will select the top members from each group and they will qualify for the next round of JAM. " +
                "The decision of the MOD will be final and binding.<br><br>" +
                "<b>Round 2 - Ping Round</b><br>" +
                "A particular topic would be given to a set of participants. " +
                "The contestants are then given one minute by the moderator to speak on the topic. " +
                "The word PING has to be introduced after EACH word. " +
                "Even the objections have the same criteria. " +
                "The decision of the MOD will be binding and final.<br><br>" +
                "<b>Round 3 - Rhyme Objection Round</b><br>" +
                "A particular nursery rhyme will have to be taken into consideration, and the contestants will have to speak a line from the poem before their speech on the topic. " +
                "The objections will have to be taken care off in the same manner. " +
                "The contestants will have to continue from the very next line of the poem spoken by the previous contestant. " +
                "In case of any dispute, the decision of the MOD will be final.<br><br>" +
                "<b>Round 4 - Single Song round</b><br>" +
                "A topic will be given to a set of contestants. " +
                "The contestants will have to speak in a particular sing song way. " +
                "Even the objections are to be made in the same manner. " +
                "You miss the rhythm and we will be sorry to miss upon you. " +
                "Needless to say, JAM MOD IS GOD! ;)<br><br>" +
                "<b>Round 5 - The Final Destination(MATHEMATICAL FORMULAE ROUND)</b><br>" +
                "Best of luck! " +
                "LUCKY enough to reach here, or UNLUCKY! " +
                "Journey to HEAVEN through HELL!"));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Parthib Dekha</b><br>" +
                "dekaparthib@gmail.com<br>" +
                "+91-99629 38712<br><br>" +
                "<b>Md. Yashab Abbas</b><br>" +
                "yashab.francis@gmail.com<br>" +
                "+91-88072 26632"));
    }

}