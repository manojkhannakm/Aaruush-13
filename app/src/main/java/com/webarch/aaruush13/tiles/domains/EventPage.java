package com.webarch.aaruush13.tiles.domains;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;

public abstract class EventPage {

    private Aaruush13 aaruush13;
    private String eventPageTitle;
    private LinearLayout eventLayout;

    public EventPage(Context context, String eventPageTitle) {
        aaruush13 = (Aaruush13) context.getApplicationContext();

        this.eventPageTitle = eventPageTitle;
    }

    public LinearLayout createView() {
        eventLayout = (LinearLayout) LayoutInflater.from(aaruush13.tileScreenActivity).inflate(R.layout.domains_event, null, false);

        TextView eventTitleTextView = (TextView) eventLayout.findViewById(R.id.domains_event_title);
        eventTitleTextView.setText(eventPageTitle);
        eventTitleTextView.setTextColor(aaruush13.tileScreenActivity.getColor2());

        onCreateView(eventLayout);

        return eventLayout;
    }

    public abstract void onCreateView(LinearLayout eventLayout);

    public void open() {
        final ScrollView domainScrollView = (ScrollView) ((RelativeLayout) eventLayout.getParent()).findViewById(R.id.domains_domain_scroll);
        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        fadeOutAnimation.setDuration(500);
        fadeOutAnimation.setFillAfter(true);
        domainScrollView.startAnimation(fadeOutAnimation);

        AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        fadeInAnimation.setDuration(500);
        eventLayout.startAnimation(fadeInAnimation);

        TranslateAnimation slideLeftAnimation = new TranslateAnimation(domainScrollView.getWidth() * 0.5f, 0.0f, 0.0f, 0.0f);
        slideLeftAnimation.setDuration(500);
        slideLeftAnimation.setFillEnabled(true);
        slideLeftAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        slideLeftAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                domainScrollView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        eventLayout.startAnimation(slideLeftAnimation);

        eventLayout.setVisibility(View.VISIBLE);
    }

    public void close() {
        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        fadeOutAnimation.setDuration(500);
        fadeOutAnimation.setFillAfter(true);
        eventLayout.startAnimation(fadeOutAnimation);

        final RelativeLayout eventPagesLayout = (RelativeLayout) eventLayout.getParent();
        ScrollView domainScrollView = (ScrollView) eventPagesLayout.findViewById(R.id.domains_domain_scroll);
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        fadeInAnimation.setDuration(500);
        domainScrollView.startAnimation(fadeInAnimation);

        TranslateAnimation slideLeftAnimation = new TranslateAnimation(eventLayout.getWidth() * 0.5f, 0.0f, 0.0f, 0.0f);
        slideLeftAnimation.setDuration(500);
        slideLeftAnimation.setFillEnabled(true);
        slideLeftAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        slideLeftAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                eventLayout.setVisibility(View.GONE);

                eventPagesLayout.post(new Runnable() {

                    @Override
                    public void run() {
                        eventPagesLayout.removeView(eventLayout);
                        eventLayout = null;
                    }

                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        domainScrollView.startAnimation(slideLeftAnimation);

        domainScrollView.setVisibility(View.VISIBLE);
    }

    public String getEventPageTitle() {
        return eventPageTitle;
    }

}