package com.webarch.aaruush13.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;

public class MenuPane extends LinearLayout {

    private Aaruush13 aaruush13;
    private boolean isOpen = false;

    public MenuPane(Context context, AttributeSet attrs) {
        super(context, attrs);

        aaruush13 = (Aaruush13) context.getApplicationContext();

        setOrientation(HORIZONTAL);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    private void open() {
        isOpen = true;

        Animation animation = getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        TranslateAnimation slideUpAnimation = new TranslateAnimation(0.0f, 0.0f, getHeight(), 0.0f);
        slideUpAnimation.setDuration(250);
        slideUpAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        startAnimation(slideUpAnimation);

        setVisibility(View.VISIBLE);
    }

    private void close() {
        isOpen = false;

        Animation animation = getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        TranslateAnimation slideDownAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, getHeight());
        slideDownAnimation.setDuration(250);
        slideDownAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        slideDownAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        startAnimation(slideDownAnimation);
    }

    public void toggle() {
        if (!isOpen) {
            open();
        } else {
            close();
        }
    }

    public void addMenuPaneBut(String menuPaneButTitle, int menuPaneButIconResId, int menuPaneButTouchedIconResId, MenuPaneButListener menuPaneButListener) {
        MenuPaneBut menuPaneBut = new MenuPaneBut(getContext());
        menuPaneBut.init(menuPaneButTitle, menuPaneButIconResId, menuPaneButTouchedIconResId, menuPaneButListener);
        addView(menuPaneBut);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public interface MenuPaneButListener {

        public void onTouched(MenuPaneBut menuPaneBut);

    }

    public class MenuPaneBut extends RelativeLayout {

        private int menuPaneButIconResId, menuPaneButTouchedIconResId;
        private MenuPaneButListener menuPaneButListener;

        private MenuPaneBut(Context context) {
            super(context);

            LayoutInflater.from(context).inflate(R.layout.menu_pane_but_layout, this, true);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(aaruush13.border2, aaruush13.border2, aaruush13.border2, aaruush13.border2);
            setLayoutParams(layoutParams);

            setOnTouchListener(new OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView menuPaneButIconImageView = (ImageView) findViewById(R.id.menu_pane_but_icon);
                    switch (event.getActionMasked()) {

                        case MotionEvent.ACTION_DOWN:
                            menuPaneButIconImageView.setImageResource(menuPaneButTouchedIconResId);
                            return true;

                        case MotionEvent.ACTION_UP:
                            menuPaneButIconImageView.setImageResource(menuPaneButIconResId);
                            menuPaneButListener.onTouched(MenuPaneBut.this);
                            return true;

                        default:
                            return false;

                    }
                }

            });
        }

        public void init(String menuPaneButTitle, int menuPaneButIconResId, int menuPaneButTouchedIconResId, MenuPaneButListener menuPaneButListener) {
            this.menuPaneButIconResId = menuPaneButIconResId;
            this.menuPaneButTouchedIconResId = menuPaneButTouchedIconResId;
            this.menuPaneButListener = menuPaneButListener;

            ((ImageView) findViewById(R.id.menu_pane_but_icon)).setImageResource(menuPaneButIconResId);
            ((TextView) findViewById(R.id.menu_pane_but_title)).setText(menuPaneButTitle);
        }

    }

}