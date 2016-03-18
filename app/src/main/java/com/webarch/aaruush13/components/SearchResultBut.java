package com.webarch.aaruush13.components;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.webarch.aaruush13.Aaruush13;

public class SearchResultBut extends TextView {

    private SearchResultButListener searchResultButListener;

    public SearchResultBut(Context context) {
        super(context);

        init(context);
    }

    public SearchResultBut(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        final Aaruush13 aaruush13 = (Aaruush13) context.getApplicationContext();

        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        setPadding(aaruush13.border1 * 2, aaruush13.border3, aaruush13.border1, aaruush13.border3);
        setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text3);
        setTextColor(Color.WHITE);
        setEllipsize(TextUtils.TruncateAt.END);
        setSingleLine(true);

        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!searchResultButListener.onClicked()) {
                    return;
                }

                ObjectAnimator colorFadeOutAnimator = ObjectAnimator.ofInt(SearchResultBut.this, "backgroundColor", aaruush13.tileScreenActivity.getColor2(), aaruush13.tileScreenActivity.getColor1()).setDuration(500);
                colorFadeOutAnimator.setEvaluator(new ArgbEvaluator());
                colorFadeOutAnimator.start();
            }

        });
    }

    public void setSearchResultButListener(SearchResultButListener searchResultButListener) {
        this.searchResultButListener = searchResultButListener;
    }

    public interface SearchResultButListener {

        public boolean onClicked();

    }

}