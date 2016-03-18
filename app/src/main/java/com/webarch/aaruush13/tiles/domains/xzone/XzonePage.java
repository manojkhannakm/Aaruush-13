package com.webarch.aaruush13.tiles.domains.xzone;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class XzonePage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("X-ZONE is entirely about non-technical events and participants can be sure of entertaining and mind racking experiences.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>V. S. Sriharsha Sivanapalli</b><br>" +
                "Event Manager, X-Zone<br>" +
                "xzone@aaruush.net<br>" +
                "+91-91769 94415"));

        addEventPage(new AdamVsEvePage(getActivity(), "Adam Vs Eve"));
        addEventPage(new FrenzyCerebroPage(getActivity(), "Frenzy Cerebro"));
        addEventPage(new GameSurroundPage(getActivity(), "Game Surround"));
        addEventPage(new HavelockPage(getActivity(), "Havelokk"));
        addEventPage(new SurvivorsQuestPage(getActivity(), "Survivors Quest"));

        return relativeLayout;
    }

}