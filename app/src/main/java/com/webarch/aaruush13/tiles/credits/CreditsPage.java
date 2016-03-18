package com.webarch.aaruush13.tiles.credits;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.PeopleTileScreenPage;

public class CreditsPage extends PeopleTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        inflater.inflate(R.layout.credits_credits, (LinearLayout) relativeLayout.findViewById(R.id.peoples_layout), true);

        return relativeLayout;
    }

}