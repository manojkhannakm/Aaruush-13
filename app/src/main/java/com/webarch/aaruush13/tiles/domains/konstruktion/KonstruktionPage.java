package com.webarch.aaruush13.tiles.domains.konstruktion;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class KonstruktionPage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("KONSTRUKTION puts together events where designing, fabricating and practically testing required models are focussed on. " + "It entails the understanding of basic functioning of core engineering fields such as mechanical and civil.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Mohammad Arshad Zubair</b><br>" +
                "Event Manager, Konstruktion<br>" +
                "konstruktion@aaruush.net<br>" +
                "+91-76676 76318"));

        addEventPage(new AngryRocketsPage(getActivity(), "Angry Rockets"));
        addEventPage(new MedievalWarfarePage(getActivity(), "Medieval Warfare"));
        addEventPage(new TheBigBridgeTheoryPage(getActivity(), "The Big Bridge Theory"));
        addEventPage(new TheWingManPage(getActivity(), "The Wing Man"));

        return relativeLayout;
    }

}