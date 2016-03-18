package com.webarch.aaruush13.components;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;

import java.util.LinkedList;

public class NavPane extends LinearLayout {

    private Aaruush13 aaruush13;
    private boolean isOpen = false;
    private LinkedList<NavPaneBut> navPaneButs = new LinkedList<NavPaneBut>();

    public NavPane(Context context, AttributeSet attrs) {
        super(context, attrs);

        aaruush13 = (Aaruush13) context.getApplicationContext();

        setOrientation(VERTICAL);

        LayoutInflater.from(context).inflate(R.layout.nav_pane_layout, this, true);

        setBackgroundColor(aaruush13.tileScreenActivity.getColor1());
    }

    private void open() {
        isOpen = true;

        final LinearLayout tileScreenContainerLayout = (LinearLayout) aaruush13.tileScreenActivity.findViewById(R.id.tile_screen_container_layout);

        Animation animation = tileScreenContainerLayout.getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        TranslateAnimation slideRightAnimation = new TranslateAnimation(0.0f, getWidth(), 0.0f, 0.0f);
        slideRightAnimation.setDuration(500);
        slideRightAnimation.setFillEnabled(true);
        slideRightAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        slideRightAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tileScreenContainerLayout.getLayoutParams();
                layoutParams.setMargins(getWidth(), 0, -getWidth(), 0);
                tileScreenContainerLayout.setLayoutParams(layoutParams);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        tileScreenContainerLayout.startAnimation(slideRightAnimation);

        Animation animation2 = getAnimation();
        if (animation2 != null) {
            animation2.cancel();
        }

        TranslateAnimation slideRightAnimation2 = new TranslateAnimation(-getWidth(), 0.0f, 0.0f, 0.0f);
        slideRightAnimation2.setDuration(1000);
        slideRightAnimation2.setFillEnabled(true);
        slideRightAnimation2.setInterpolator(new DecelerateInterpolator(1.5f));
        startAnimation(slideRightAnimation2);

        setVisibility(View.VISIBLE);
    }

    private void close() {
        isOpen = false;

        final LinearLayout tileScreenContainerLayout = (LinearLayout) aaruush13.tileScreenActivity.findViewById(R.id.tile_screen_container_layout);

        Animation animation = tileScreenContainerLayout.getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        TranslateAnimation slideLeftAnimation = new TranslateAnimation(0.0f, -getWidth(), 0.0f, 0.0f);
        slideLeftAnimation.setDuration(500);
        slideLeftAnimation.setFillEnabled(true);
        slideLeftAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        slideLeftAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tileScreenContainerLayout.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                tileScreenContainerLayout.setLayoutParams(layoutParams);

                setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        tileScreenContainerLayout.startAnimation(slideLeftAnimation);
    }

    public void toggle() {
        if (!isOpen) {
            open();
        } else {
            close();
        }
    }

    public void addNavPaneBut(String tileScreenPageTitle) {
        NavPaneBut navPaneBut = new NavPaneBut(tileScreenPageTitle);
        ((LinearLayout) findViewById(R.id.nav_buts_layout)).addView(navPaneBut);
        navPaneButs.add(navPaneBut);
    }

    public NavPaneBut getNavPaneBut(int index) {
        return navPaneButs.get(index);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public class NavPaneBut extends TextView {

        private ObjectAnimator navButAnimator;

        private NavPaneBut(final String tileScreenPageTitle) {
            super(NavPane.this.getContext());

            setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            setPadding(aaruush13.border1, aaruush13.border2, aaruush13.border1, aaruush13.border2);
            setText(tileScreenPageTitle);
            setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text2);
            setTextColor(Color.WHITE);
            setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    aaruush13.tileScreenActivity.openTileScreenPage(tileScreenPageTitle, null);
                }

            });
        }

        public void setClicked(boolean clicked) {
            if (navButAnimator != null) {
                navButAnimator.end();
            }

            if (clicked) {
                navButAnimator = ObjectAnimator.ofInt(this, "backgroundColor", aaruush13.tileScreenActivity.getColor1(), aaruush13.tileScreenActivity.getColor2());
            } else {
                navButAnimator = ObjectAnimator.ofInt(this, "backgroundColor", aaruush13.tileScreenActivity.getColor2(), aaruush13.tileScreenActivity.getColor1());
            }

            navButAnimator.setEvaluator(new ArgbEvaluator());
            navButAnimator.setDuration(250);
            navButAnimator.start();
        }

    }

}