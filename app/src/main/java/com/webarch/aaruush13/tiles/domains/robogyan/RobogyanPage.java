package com.webarch.aaruush13.tiles.domains.robogyan;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.domains.DomainTileScreenPage;

public class RobogyanPage extends DomainTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_introduction)).setText("ROBOGYAN consists of events that provide opportunities to innovate and create their own robots with unique specifications for each event. " + "All types of manual, semi-autonomous and autonomous robotic events are accepted.");

        ((TextView) relativeLayout.findViewById(R.id.domains_domain_contacts)).setText(Html.fromHtml("<b>Sai Venkat Vanka</b><br>" +
                "Event Manager, Robogyan<br>" +
                "robogyan@aaruush.net<br>" +
                "+91-94448 72654"));

        addEventPage(new MazeOSoccerPage(getActivity(), "Maze O' Soccer"));
        addEventPage(new RoboRangersPage(getActivity(), "Robo Rangers"));
        addEventPage(new RoboVenturePage(getActivity(), "Robo Venture"));
        addEventPage(new WalkOnTheRopePage(getActivity(), "Walk On The Rope"));

        return relativeLayout;
    }

}