package com.webarch.aaruush13.tiles.domains.specials;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class SpecialsPage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("This Domain consists of events with mix of all engineering fields, with extreme fun quotient. " + "These eye catching events are distibuted throughout the four days of Aaruush for the entertainment of participants and spectators.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Malvika Chandhok</b><br>" +
                "Event Oraganizer<br>" +
                "event.org@aaruush.net<br>" +
                "+91-97909 50168"));

        addEventPage(new BellTheBullPage(getActivity(), "Bell The Bull"));
        addEventPage(new DextersMantraReloadedPage(getActivity(), "Dexter's Mantra Reloaded"));
        addEventPage(new InfiniteStakesPage(getActivity(), "Infinite Stakes"));
        addEventPage(new RobothonPage(getActivity(), "Robothon"));
        addEventPage(new TheRaceDaemonPage(getActivity(), "The Race Daemon"));

        return relativeLayout;
    }

}