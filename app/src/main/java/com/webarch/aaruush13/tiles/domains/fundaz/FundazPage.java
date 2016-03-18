package com.webarch.aaruush13.tiles.domains.fundaz;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class FundazPage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("FUNDAZ consists of events which deal with the fundamental notions of science, basics that one learns from grades 10 to 12 in school.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Kshitij Narang</b><br>" +
                "Event Manager, Fundaz<br>" +
                "fundaz@aaruush.net<br>" +
                "+91-80561 92099"));

        addEventPage(new DingPage(getActivity(), "DiNG"));
        addEventPage(new SackingScroogePage(getActivity(), "Sacking Scrooge"));
        addEventPage(new TheUncommonSensePage(getActivity(), "The Uncommon Sense"));
        addEventPage(new UncomplicatePage(getActivity(), "Uncomplicate"));
        addEventPage(new XploraPage(getActivity(), "Xplora"));

        return relativeLayout;
    }

}