package com.webarch.aaruush13.tiles.domains.online;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class OnlinePage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("ONLINE events ensure participation of students on an international level. " + "These events include games, puzzles, treasure hunt and other technical competitions.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Arun Iyer</b><br>" +
                "Event Manager, Online<br>" +
                "online@aaruush.net<br>" +
                "+91-95660 52033"));

        addEventPage(new IntrudeTheCastlePage(getActivity(), "Intrude The Castle"));
        addEventPage(new KryptonixPage(getActivity(), "Kryptonix"));
        addEventPage(new PicACamPage(getActivity(), "Pic A Cam"));

        return relativeLayout;
    }

}