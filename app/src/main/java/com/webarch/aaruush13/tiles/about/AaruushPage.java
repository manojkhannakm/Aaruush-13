package com.webarch.aaruush13.tiles.about;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.TileScreenPage;

public class AaruushPage extends TileScreenPage {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView scrollView = (ScrollView) inflater.inflate(R.layout.about_aaruush, container, false);

        ((TextView) scrollView.findViewById(R.id.about_aaruush_text_1)).setText("     \"Seek and you shall find, when you feel everything is lost, innovation will guide you through\".");

        ((TextView) scrollView.findViewById(R.id.about_aaruush_text_2)).setText("     " + Html.fromHtml("<p>Taking cue from these words by our former President, Dr. APJ Abdul Kalam, SRM University's National Level Techno-Management Fest, Aaruush quenches our thirst for innovative prerogatives.</p>") +
                "     " + Html.fromHtml("<p>Since its inception in the year 2007, this brainchild of four final year students has sought to provide a platform where students can showcase a fine blend of imagination and technical dexterity. Aaruush continues to delve into unexplored avenues, leading us to do things in ways that are truly unique and exciting.</p>") +
                "     " + Html.fromHtml("With each passing year, Aaruush has evolved into a phenomenon that stands true to its mantra of \"invent, innovate and inspire.\" Themes have proven to be a unique amalgamation of technology, management and societal issues. Along with associating itself with various causes, Aaruush has pioneered a change not only in ideas, but also in mindset, making innovation an intrinsic part of life."));

        setSearchScrollView(scrollView);
        addSearchTag("aaruush", 0);
        addSearchTag("apj", 24);
        addSearchTag("abdul", 24);
        addSearchTag("kalam", 24);
        addSearchTag("legacy", 100);

        return scrollView;
    }

}