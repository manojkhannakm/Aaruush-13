package com.webarch.aaruush13.tiles.domains;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.TileScreenPage;

import java.util.LinkedList;

public class DomainTileScreenPage extends TileScreenPage {

    private LinkedList<EventPage> eventPages = new LinkedList<EventPage>();
    private int curEventPageIndex = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.domains_domain, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("curEventPageIndex", curEventPageIndex);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (EventPage eventPage : eventPages) {
            addEventPageBut(eventPage);
        }

        if (savedInstanceState != null) {
            curEventPageIndex = savedInstanceState.getInt("curEventPageIndex");
            if (curEventPageIndex > -1) {
                addEventPageView(eventPages.get(curEventPageIndex));
                view.findViewById(R.id.domains_domain_scroll).setVisibility(View.GONE);
                setBackKeyEnabled(true);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (curEventPageIndex > -1) {
            setBackKeyEnabled(false);
            eventPages.get(curEventPageIndex).close();
            curEventPageIndex = -1;
        }
    }

    private void addEventPageBut(final EventPage eventPage) {
        final TextView eventPageButTextView = new TextView(getActivity());
        eventPageButTextView.setPadding(aaruush13.border2, aaruush13.border2, aaruush13.border2, aaruush13.border2);
        eventPageButTextView.setText(eventPage.getEventPageTitle());
        eventPageButTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text3);
        eventPageButTextView.setTextColor(Color.WHITE);
        final GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{
                aaruush13.tileScreenActivity.getColor1(),
                aaruush13.tileScreenActivity.getColor1(),
                aaruush13.tileScreenActivity.getColor2()
        });
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            eventPageButTextView.setBackgroundDrawable(gradientDrawable);
        } else {
            eventPageButTextView.setBackground(gradientDrawable);
        }

        eventPageButTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (curEventPageIndex > -1) {
                    return;
                }

                curEventPageIndex = eventPages.indexOf(eventPage);

                gradientDrawable.setStroke(aaruush13.border2, aaruush13.tileScreenActivity.getColor2());

                ScaleAnimation zoomOutAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                zoomOutAnimation.setDuration(100);
                zoomOutAnimation.setFillAfter(true);
                eventPageButTextView.startAnimation(zoomOutAnimation);

                ScaleAnimation zoomInAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                zoomInAnimation.setDuration(100);
                zoomInAnimation.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        gradientDrawable.setStroke(0, Color.TRANSPARENT);

                        addEventPageView(eventPage);
                        eventPage.open();
                        setBackKeyEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                });
                eventPageButTextView.startAnimation(zoomInAnimation);
            }

        });

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = aaruush13.border2;
        ((LinearLayout) getView().findViewById(R.id.domains_domain_layout)).addView(eventPageButTextView, layoutParams);
    }

    private void addEventPageView(final EventPage eventPage) {
        LinearLayout eventLayout = eventPage.createView();
        eventLayout.findViewById(R.id.domains_event_back).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (curEventPageIndex > -1) {
                    setBackKeyEnabled(false);
                    eventPage.close();
                    curEventPageIndex = -1;
                }
            }

        });
        ((RelativeLayout) getView().findViewById(R.id.domains_domain_event_pages_layout)).addView(eventLayout, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
    }

    protected void addEventPage(EventPage eventPage) {
        eventPages.add(eventPage);
    }

}