package com.webarch.aaruush13.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;

import java.util.LinkedList;

public class CollapsibleView extends LinearLayout {

    private Aaruush13 aaruush13;
    private LinkedList<CollapsibleBut> collapsibleButs = new LinkedList<CollapsibleBut>();
    private int curCollapsibleButIndex = -1;

    public CollapsibleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        aaruush13 = (Aaruush13) context.getApplicationContext();
    }

    public void addPanel(String collapsibleButTitle, CharSequence collapsiblePanelContent) {
        TextView collapsiblePanelTextView = new TextView(getContext());
        collapsiblePanelTextView.setText(collapsiblePanelContent);
        collapsiblePanelTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text3);
        collapsiblePanelTextView.setTextColor(Color.BLACK);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(aaruush13.border2, aaruush13.border2, aaruush13.border2, aaruush13.border2);
        addView(collapsiblePanelTextView, layoutParams);

        CollapsibleBut collapsibleBut = new CollapsibleBut(getContext(), collapsibleButTitle, collapsiblePanelTextView);
        addView(collapsibleBut, indexOfChild(collapsiblePanelTextView));
        collapsibleButs.add(collapsibleBut);
    }

    private class CollapsibleBut extends RelativeLayout {

        private TextView collapsiblePanelTextView;
        private int collapsiblePanelHeight;

        private CollapsibleBut(Context context, String collapsibleButTitle, final TextView collapsiblePanelTextView) {
            super(context);

            this.collapsiblePanelTextView = collapsiblePanelTextView;

            setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            setPadding(aaruush13.border2, aaruush13.border2, aaruush13.border2, aaruush13.border2);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{
                    aaruush13.tileScreenActivity.getColor1(),
                    aaruush13.tileScreenActivity.getColor1(),
                    aaruush13.tileScreenActivity.getColor2()
            });
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                //noinspection deprecation
                setBackgroundDrawable(gradientDrawable);
            } else {
                setBackground(gradientDrawable);
            }

            LayoutInflater.from(context).inflate(R.layout.collapsible_but_layout, this, true);

            ((TextView) findViewById(R.id.collapsible_but_title)).setText(collapsibleButTitle);

            setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    int collapsibleButIndex = collapsibleButs.indexOf(CollapsibleBut.this);

                    if (curCollapsibleButIndex == -1) {
                        expand();
                        curCollapsibleButIndex = collapsibleButIndex;
                    } else if (curCollapsibleButIndex == collapsibleButIndex) {
                        collapse();
                        curCollapsibleButIndex = -1;
                    } else {
                        collapsibleButs.get(curCollapsibleButIndex).collapse();
                        expand();
                        curCollapsibleButIndex = collapsibleButIndex;
                    }
                }

            });

            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                @Override
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        //noinspection deprecation
                        getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    collapsiblePanelHeight = collapsiblePanelTextView.getHeight() + aaruush13.border2 * 2;
                    collapsiblePanelTextView.setVisibility(GONE);
                }

            });
        }

        private void expand() {
            ValueAnimator expandAnimator = ValueAnimator.ofInt(0, collapsiblePanelHeight).setDuration(500);
            final ScrollView eventScrollView = (ScrollView) CollapsibleView.this.getParent().getParent();
            expandAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    LinearLayout.LayoutParams layoutParams = ((LinearLayout.LayoutParams) getLayoutParams());
                    layoutParams.bottomMargin = (Integer) animation.getAnimatedValue();
                    setLayoutParams(layoutParams);

                    View view = CollapsibleBut.this;
                    int y = -aaruush13.border2;
                    while (view != eventScrollView) {
                        y += view.getTop();
                        view = (View) view.getParent();
                    }

                    eventScrollView.smoothScrollTo(0, y);
                }

            });
            expandAnimator.setInterpolator(new DecelerateInterpolator(1.5f));
            expandAnimator.start();

            ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(findViewById(R.id.collapsible_but_arrow), "rotation", 0.0f, 90.0f).setDuration(500);
            rotateAnimator.addListener(new AnimatorListenerAdapter() {

                @Override
                public void onAnimationEnd(Animator animation) {
                    ObjectAnimator.ofFloat(collapsiblePanelTextView, "alpha", 0.0f, 1.0f).setDuration(100).start();

                    LinearLayout.LayoutParams layoutParams = ((LinearLayout.LayoutParams) getLayoutParams());
                    layoutParams.bottomMargin = 0;
                    setLayoutParams(layoutParams);

                    collapsiblePanelTextView.setVisibility(VISIBLE);
                }

            });
            rotateAnimator.start();
        }

        private void collapse() {
            ObjectAnimator fadeOutAnimator = ObjectAnimator.ofFloat(collapsiblePanelTextView, "alpha", 1.0f, 0.0f).setDuration(100);
            fadeOutAnimator.addListener(new AnimatorListenerAdapter() {

                @Override
                public void onAnimationEnd(Animator animation) {
                    collapsiblePanelTextView.setVisibility(GONE);

                    LinearLayout.LayoutParams layoutParams = ((LinearLayout.LayoutParams) getLayoutParams());
                    layoutParams.bottomMargin = collapsiblePanelHeight;
                    setLayoutParams(layoutParams);

                    ValueAnimator collapseAnimator = ValueAnimator.ofInt(collapsiblePanelHeight, 0).setDuration(500);
                    collapseAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            LinearLayout.LayoutParams layoutParams = ((LinearLayout.LayoutParams) getLayoutParams());
                            layoutParams.bottomMargin = (Integer) animation.getAnimatedValue();
                            setLayoutParams(layoutParams);
                        }

                    });
                    collapseAnimator.setInterpolator(new DecelerateInterpolator(1.5f));
                    collapseAnimator.start();

                    ObjectAnimator.ofFloat(findViewById(R.id.collapsible_but_arrow), "rotation", 90.0f, 0.0f).setDuration(500).start();
                }

            });
            fadeOutAnimator.start();
        }

    }

}