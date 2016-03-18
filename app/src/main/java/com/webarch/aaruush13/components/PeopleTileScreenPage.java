package com.webarch.aaruush13.components;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.webarch.aaruush13.R;

public class PeopleTileScreenPage extends TileScreenPage {

    private AnimatorSet peopleDetailLayoutAnimatorSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.peoples, container, false);

        setSearchScrollView((ScrollView) relativeLayout.findViewById(R.id.peoples_scroll));

        return relativeLayout;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout peoplesLayout = (LinearLayout) view.findViewById(R.id.peoples_layout);
        RelativeLayout peopleDetailContainerLayout = (RelativeLayout) view.findViewById(R.id.people_detail_container_layout);
        for (int i = 0; i < peoplesLayout.getChildCount(); i++) {
            View childView = peoplesLayout.getChildAt(i);
            if (childView instanceof TextView) {
                addSearchTag(((TextView) childView).getText().toString(), childView);
            } else if (childView instanceof PeopleView) {
                final PeopleView peopleView = (PeopleView) childView;
                peopleView.setPeopleDetailContainerLayout(peopleDetailContainerLayout);
                peopleView.setPeopleDetailLayoutAnimatorSet(peopleDetailLayoutAnimatorSet);
                peopleView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        peopleView.showDetail();
                        setBackKeyEnabled(true);
                    }

                });

                addSearchTag(((TextView) peopleView.findViewById(R.id.people_name)).getText().toString(), peopleView);
            }
        }

        peopleDetailContainerLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hideDetail();
            }

        });
    }

    @Override
    public void onSearch(String searchResult) {
        super.onSearch(searchResult);

        Object object = getSearchTagObject(searchResult);
        if (object instanceof PeopleView) {
            ((PeopleView) object).showDetail();
        }
        setBackKeyEnabled(true);
    }

    @Override
    public void onBackPressed() {
        hideDetail();
    }

    private void hideDetail() {
        if (peopleDetailLayoutAnimatorSet != null && peopleDetailLayoutAnimatorSet.isRunning()) {
            peopleDetailLayoutAnimatorSet.end();
        }

        setBackKeyEnabled(false);

        final RelativeLayout peopleDetailContainerLayout = (RelativeLayout) getView().findViewById(R.id.people_detail_container_layout),
                peopleDetailLayout = (RelativeLayout) peopleDetailContainerLayout.findViewById(R.id.people_detail_layout);

        peopleDetailLayoutAnimatorSet = new AnimatorSet();
        peopleDetailLayoutAnimatorSet.play(ObjectAnimator.ofFloat(peopleDetailLayout, "alpha", 1.0f, 1.0f)).with(ObjectAnimator.ofFloat(peopleDetailLayout, "scaleX", 1.0f, 0.0f)).with(ObjectAnimator.ofFloat(peopleDetailLayout, "scaleY", 1.0f, 0.0f));
        peopleDetailLayoutAnimatorSet.setDuration(250);
        peopleDetailLayoutAnimatorSet.setInterpolator(new AnticipateInterpolator());
        peopleDetailLayoutAnimatorSet.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                peopleDetailContainerLayout.setVisibility(View.INVISIBLE);
            }

        });
        peopleDetailLayoutAnimatorSet.start();
    }

}