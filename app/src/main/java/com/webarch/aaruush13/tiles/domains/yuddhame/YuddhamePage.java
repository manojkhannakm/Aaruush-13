package com.webarch.aaruush13.tiles.domains.yuddhame;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class YuddhamePage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("YUDDHAME aims at honing the software and hardware skills of the participants. " + "More specifically: coding in various programming languages and platforms, web designing, integrated circuits, networking and communication techniques.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Ashutosh Agrawal</b><br>" +
                "Event Manager, Yuddhame<br>" +
                "yuddhame@aaruush.net<br>" +
                "+91-94452 77205"));

        addEventPage(new JeuDesGeeksPage(getActivity(), "Jeu Des Geeks"));
        addEventPage(new OOPSCanYouDoItPage(getActivity(), "OOPS Can You Do It?"));
        addEventPage(new SaveTheQueenPage(getActivity(), "Save The Queen"));
        addEventPage(new WebODesignPage(getActivity(), "Web-O-Design"));

        return relativeLayout;
    }

}