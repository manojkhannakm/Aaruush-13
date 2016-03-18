package com.webarch.aaruush13.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;
import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;

public class FacebookLogin extends LinearLayout {

    private Aaruush13 aaruush13;
    private boolean isOpen = false;

    public FacebookLogin(Context context, AttributeSet attrs) {
        super(context, attrs);

        aaruush13 = (Aaruush13) context.getApplicationContext();

        LayoutInflater.from(context).inflate(R.layout.facebook_login_layout, this, true);

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isOpen) {
            close();
        }
        return true;
    }

    public void open() {
        isOpen = true;

        Animation animation = getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        fadeInAnimation.setDuration(250);
        startAnimation(fadeInAnimation);

        setVisibility(View.VISIBLE);
    }

    public void close() {
        isOpen = false;

        Animation animation = getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        fadeOutAnimation.setDuration(250);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        startAnimation(fadeOutAnimation);
    }

    public void loggedIn() {
        Request.newMeRequest(Session.getActiveSession(), new Request.GraphUserCallback() {

            @Override
            public void onCompleted(GraphUser user, Response response) {
                if (user != null) {
                    ProfilePictureView facebookLoginPicProfilePictureView = (ProfilePictureView) findViewById(R.id.facebook_login_pic);
                    facebookLoginPicProfilePictureView.setProfileId(user.getId());
                    facebookLoginPicProfilePictureView.setVisibility(VISIBLE);

                    TextView facebookLoginNameTextView = (TextView) findViewById(R.id.facebook_login_name);
                    facebookLoginNameTextView.setText(user.getName());
                    facebookLoginNameTextView.setVisibility(VISIBLE);

                    for (Tile tile : aaruush13.mainActivity.getTiles()) {
                        tile.facebookLoggedIn(user);
                    }
                }
            }

        }).executeAsync();
    }

    public void loggedOut() {
        findViewById(R.id.facebook_login_pic).setVisibility(GONE);

        TextView facebookLoginNameTextView = (TextView) findViewById(R.id.facebook_login_name);
        facebookLoginNameTextView.setText("");
        facebookLoginNameTextView.setVisibility(GONE);

        for (Tile tile : aaruush13.mainActivity.getTiles()) {
            tile.facebookLoggedOut();
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

}