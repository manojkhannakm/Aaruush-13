package com.webarch.aaruush13.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;

public class PeopleView extends RelativeLayout {

    private Aaruush13 aaruush13;
    private int picResId;
    private String name, title, email, phone;
    private RelativeLayout peopleDetailContainerLayout;
    private AnimatorSet peopleDetailLayoutAnimatorSet;

    public PeopleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        aaruush13 = (Aaruush13) context.getApplicationContext();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PeopleView);
        picResId = typedArray.getResourceId(R.styleable.PeopleView_people_pic, 0);
        name = typedArray.getString(R.styleable.PeopleView_people_name);
        title = typedArray.getString(R.styleable.PeopleView_people_title);
        email = typedArray.getString(R.styleable.PeopleView_people_email);
        phone = typedArray.getString(R.styleable.PeopleView_people_phone);
        typedArray.recycle();

        LayoutInflater.from(context).inflate(R.layout.people_layout, this, true);
        Bitmap picBitmap = BitmapFactory.decodeResource(getResources(), picResId);
        ((ImageView) findViewById(R.id.people_thumb)).setImageBitmap(Bitmap.createScaledBitmap(picBitmap, (int) (picBitmap.getWidth() / 2.5f), (int) (picBitmap.getHeight() / 2.5f), true));
        ((TextView) findViewById(R.id.people_name)).setText(name);
        ((TextView) findViewById(R.id.people_title)).setText(title);
    }

    public void showDetail() {
        if (peopleDetailLayoutAnimatorSet != null && peopleDetailLayoutAnimatorSet.isRunning()) {
            peopleDetailLayoutAnimatorSet.end();
        }

        peopleDetailContainerLayout.removeAllViews();
        peopleDetailContainerLayout.setVisibility(VISIBLE);

        LayoutInflater.from(getContext()).inflate(R.layout.people_detail_layout, peopleDetailContainerLayout, true);
        RelativeLayout peopleDetailLayout = (RelativeLayout) peopleDetailContainerLayout.findViewById(R.id.people_detail_layout);
        peopleDetailLayout.setBackgroundColor(aaruush13.tileScreenActivity.getColor2());
        ((ImageView) peopleDetailLayout.findViewById(R.id.people_pic)).setImageResource(picResId);
        ((TextView) peopleDetailLayout.findViewById(R.id.people_name)).setText(name);
        ((TextView) peopleDetailLayout.findViewById(R.id.people_title)).setText(title);
        ((TextView) peopleDetailLayout.findViewById(R.id.people_email)).setText(email);
        ((TextView) peopleDetailLayout.findViewById(R.id.people_phone)).setText(phone);

        ObjectAnimator colorFadeOutAnimator = ObjectAnimator.ofInt(this, "backgroundColor", aaruush13.tileScreenActivity.getColor2(), Color.WHITE);
        colorFadeOutAnimator.setEvaluator(new ArgbEvaluator());

        peopleDetailLayoutAnimatorSet = new AnimatorSet();
        peopleDetailLayoutAnimatorSet.play(colorFadeOutAnimator).with(ObjectAnimator.ofFloat(peopleDetailLayout, "alpha", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(peopleDetailLayout, "scaleX", 0.0f, 1.0f)).with(ObjectAnimator.ofFloat(peopleDetailLayout, "scaleY", 0.0f, 1.0f));
        peopleDetailLayoutAnimatorSet.setDuration(250);
        peopleDetailLayoutAnimatorSet.setInterpolator(new AccelerateInterpolator());
        peopleDetailLayoutAnimatorSet.start();
    }

    public void setPeopleDetailContainerLayout(RelativeLayout peopleDetailContainerLayout) {
        this.peopleDetailContainerLayout = peopleDetailContainerLayout;
    }

    public void setPeopleDetailLayoutAnimatorSet(AnimatorSet peopleDetailLayoutAnimatorSet) {
        this.peopleDetailLayoutAnimatorSet = peopleDetailLayoutAnimatorSet;
    }

}