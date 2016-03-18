package com.webarch.aaruush13.tiles;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webarch.aaruush13.components.TileScreenPage;

public class ComingSoonPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("Coming soon...");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text3);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.BLACK);
        return textView;
    }

}