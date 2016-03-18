package com.webarch.aaruush13.tiles.domains.specials;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.CollapsibleView;
import com.webarch.aaruush13.tiles.domains.EventPage;

public class InfiniteStakesPage extends EventPage {

    public InfiniteStakesPage(Context context, String eventPageTitle) {
        super(context, eventPageTitle);
    }

    @Override
    public void onCreateView(LinearLayout eventLayout) {
        ((TextView) eventLayout.findViewById(R.id.domains_event_description)).setText("(Wanted your life to be as interesting and smooth as James Bond? Well, this is your chance!) Long gone are the times when we actually attended fairs to ward off boredom. " +
                "So, to bring back those memories we as the special event of Aaruush have organized a carnival. " +
                "15 exciting events being played simultaneously bring back the memories of festivities; the exact memories that we long for. " +
                "This event has only one aim: to entertain everybody, TOGETHER irrespective of age. " +
                "But, this is not all. " +
                "We also have a twisted treasure hunt in store for Round 2 and a mystery ridden puzzle in round 3 (where you are actually shut in a room). " +
                "And oh! Did we forget something? Yes. " +
                "The participants would be working as JAMES BOND's apprentices! " +
                "So when coming to Aaruush, don't forget to attend your ultimate chance to be the second best spy in the world!");

        CollapsibleView eventCollapsibleView = (CollapsibleView) eventLayout.findViewById(R.id.domains_event_details);

        eventCollapsibleView.addPanel("Introduction", "(Wanted your life to be as interesting and smooth as James Bond? Well, this is your chance!) Long gone are the times when we actually attended fairs to ward off boredom. " +
                "So, to bring back those memories we as the special event of Aaruush have organized a carnival. " +
                "15 exciting events being played simultaneously bring back the memories of festivities; the exact memories that we long for. " +
                "This event has only one aim: to entertain everybody, TOGETHER irrespective of age. " +
                "But, this is not all. " +
                "We also have a twisted treasure hunt in store for Round 2 and a mystery ridden puzzle in round 3 (where you are actually shut in a room). " +
                "And oh! Did we forget something? Yes. " +
                "The participants would be working as JAMES BOND's apprentices! " +
                "So when coming to Aaruush, don't forget to attend your ultimate chance to be the second best spy in the world!");

        eventCollapsibleView.addPanel("Details", Html.fromHtml("<b>Round 1</b><br>" +
                "A carnival. A fair in its true sense with 9 main events, 5 mock events and 1 amazing video playback to spread smiles across.<br><br>" +
                "<b>Round 2</b><br>" +
                "Voila! Your first chance to embody the spy inside you in the best Treasure Hunt of Aaruush'13.<br><br>" +
                "<b>Round 3</b><br>" +
                "Now, you are among the elite class of agents. Prove your mettle with a calm but exciting puzzle round and win your ticket to the FINAL SHOWDOWN with the most dangerous of the villains, who's out there to destroy the world. Are you the one to save it?"));

        eventCollapsibleView.addPanel("Contacts", Html.fromHtml("<b>Raveesh Mehta</b><br>" +
                "raveesh94@yahoo.co.in<br>" +
                "+91-99629 40387<br><br>" +
                "Sahil Sharma<br>" +
                "smartsahilsharma18@gmail.com<br>" +
                "+91-95432 06450<br><br>" +
                "Tarun Batra<br>" +
                "tarun.batra00@gmail.com<br>" +
                "+91-87545 00208<br><br>" +
                "Goutam Kolla<br>" +
                "gouthamkolla@hotmail.com<br>" +
                "+91-97910 59295"));
    }

}