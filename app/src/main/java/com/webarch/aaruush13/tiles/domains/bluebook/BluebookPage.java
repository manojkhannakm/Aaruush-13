package com.webarch.aaruush13.tiles.domains.bluebook;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class BluebookPage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("BLUEBOOK covers events relating to the fields of bioengineering, life sciences, biology and chemistry. " + "Every event makes sure the participant gains practical knowledge and also tests the theoretical aspects of a wide range of topics.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Nandini Ravichandran</b><br>" +
                "Event Manager, Bluebook<br>" +
                "bluebook@aaruush.net<br>" +
                "+91-97907 61445"));

        addEventPage(new BloodAndBonesPage(getActivity(), "Blood And Bones"));
        addEventPage(new ElequestPage(getActivity(), "Elequest"));
        addEventPage(new EstriktiPage(getActivity(), "Estrikti"));
        addEventPage(new PapyrusPage(getActivity(), "Papyrus"));

        return relativeLayout;
    }

}