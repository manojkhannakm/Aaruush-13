package com.webarch.aaruush13.tiles.contacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.PeopleTileScreenPage;

public class ContactsPage extends PeopleTileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);

        inflater.inflate(R.layout.contacts_contacts, (LinearLayout) relativeLayout.findViewById(R.id.peoples_layout), true);

        return relativeLayout;
    }

}