package com.webarch.aaruush13.tiles.domains.praesentatio;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class PraesentatioPage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("PRAESENTATIO helps provide a platform for participants who are interested in paper or model presentations as well as exhibitions backed with substantial proof to showcase their knowledge in their field of interest.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Naga Sai Anoop</b><br>" +
                "Event Manager, Praesentatio<br>" +
                "praesentatio@aaruush.net<br>" +
                "+91-89390 13970"));

        addEventPage(new CallOfDebatePage(getActivity(), "Call Of Debate"));
        addEventPage(new JAMPage(getActivity(), "J. A. M."));
        addEventPage(new PaperPresentationPage(getActivity(), "Paper Presentation"));
        addEventPage(new TeachOTechPage(getActivity(), "Teach O Tech"));

        return relativeLayout;
    }

}