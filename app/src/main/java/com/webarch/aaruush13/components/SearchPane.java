package com.webarch.aaruush13.components;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SearchPane extends LinearLayout {

    private Aaruush13 aaruush13;
    private boolean isOpen = false;
    private HashMap<String, String[]> searchTagsMap;

    public SearchPane(Context context, AttributeSet attrs) {
        super(context, attrs);

        aaruush13 = (Aaruush13) context.getApplicationContext();

        setOrientation(VERTICAL);
        setBackgroundColor(aaruush13.tileScreenActivity.getColor1());

        LayoutInflater.from(context).inflate(R.layout.search_pane_layout, this, true);

        final EditText searchEditText = (EditText) findViewById(R.id.search_box);
        final SharedPreferences preferences = aaruush13.tileScreenActivity.getSharedPreferences(aaruush13.tileScreenActivity.getTileScreenTitle(), Context.MODE_PRIVATE);
        searchEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(final Editable s) {
                final String searchText = searchEditText.getText().toString();
                searchEditText.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        if (!searchEditText.getText().toString().equals(searchText)) {
                            return;
                        }
                        if (searchText.length() >= 3) {
                            showSearchResults(searchText.toLowerCase());

                            searchEditText.postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    if (!searchEditText.getText().toString().equals(searchText) || preferences.getString("SearchRecent1", "").equals(searchText)) {
                                        return;
                                    }
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString("SearchRecent3", preferences.getString("SearchRecent2", ""));
                                    editor.putString("SearchRecent2", preferences.getString("SearchRecent1", ""));
                                    editor.putString("SearchRecent1", searchText);
                                    editor.commit();
                                }

                            }, 3000);
                        } else {
                            showRecentSearches();
                        }
                    }

                }, 500);
            }

        });

        findViewById(R.id.search_clear).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                searchEditText.setText("");
            }

        });

        final SearchResultBut recent1SearchResultBut = (SearchResultBut) findViewById(R.id.recent_1);
        recent1SearchResultBut.setText(preferences.getString("SearchRecent1", "No recent searches!"));
        recent1SearchResultBut.setSearchResultButListener(new SearchResultBut.SearchResultButListener() {

            @Override
            public boolean onClicked() {
                String recent1Text = recent1SearchResultBut.getText().toString();
                if (recent1Text.equals("No recent searches!")) {
                    return false;
                }
                searchEditText.setText(recent1Text);
                searchEditText.setSelection(recent1Text.length());
                return true;
            }

        });

        final SearchResultBut recent2SearchResultBut = (SearchResultBut) findViewById(R.id.recent_2);
        recent2SearchResultBut.setText(preferences.getString("SearchRecent2", ""));
        recent2SearchResultBut.setSearchResultButListener(new SearchResultBut.SearchResultButListener() {

            @Override
            public boolean onClicked() {
                String recent2Text = recent2SearchResultBut.getText().toString();
                searchEditText.setText(recent2Text);
                searchEditText.setSelection(recent2Text.length());
                return true;
            }

        });
        if (!recent2SearchResultBut.getText().toString().isEmpty()) {
            recent2SearchResultBut.setVisibility(VISIBLE);
        }

        final SearchResultBut recent3SearchResultBut = (SearchResultBut) findViewById(R.id.recent_3);
        recent3SearchResultBut.setText(preferences.getString("SearchRecent3", ""));
        recent3SearchResultBut.setSearchResultButListener(new SearchResultBut.SearchResultButListener() {

            @Override
            public boolean onClicked() {
                String recent3Text = recent3SearchResultBut.getText().toString();
                searchEditText.setText(recent3Text);
                searchEditText.setSelection(recent3Text.length());
                return true;
            }

        });
        if (!recent3SearchResultBut.getText().toString().isEmpty()) {
            recent3SearchResultBut.setVisibility(VISIBLE);
        }

        final SearchResultBut suggestion1SearchResultBut = (SearchResultBut) findViewById(R.id.suggestion_1);
        suggestion1SearchResultBut.setSearchResultButListener(new SearchResultBut.SearchResultButListener() {

            @Override
            public boolean onClicked() {
                String suggestion1Text = suggestion1SearchResultBut.getText().toString();
                if (suggestion1Text.equals("No suggestions!")) {
                    return false;
                }
                searchEditText.setText(suggestion1Text);
                searchEditText.setSelection(suggestion1Text.length());
                return true;
            }

        });

        final SearchResultBut suggestion2SearchResultBut = (SearchResultBut) findViewById(R.id.suggestion_2);
        suggestion2SearchResultBut.setSearchResultButListener(new SearchResultBut.SearchResultButListener() {

            @Override
            public boolean onClicked() {
                String suggestion2Text = suggestion2SearchResultBut.getText().toString();
                searchEditText.setText(suggestion2Text);
                searchEditText.setSelection(suggestion2Text.length());
                return true;
            }

        });

        final SearchResultBut suggestion3SearchResultBut = (SearchResultBut) findViewById(R.id.suggestion_3);
        suggestion3SearchResultBut.setSearchResultButListener(new SearchResultBut.SearchResultButListener() {

            @Override
            public boolean onClicked() {
                String suggestion3Text = suggestion3SearchResultBut.getText().toString();
                searchEditText.setText(suggestion3Text);
                searchEditText.setSelection(suggestion3Text.length());
                return true;
            }

        });
    }

    private void open() {
        isOpen = true;

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
                layoutParams.setMargins(-getWidth(), 0, getWidth(), 0);
                tileScreenContainerLayout.setLayoutParams(layoutParams);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        tileScreenContainerLayout.startAnimation(slideLeftAnimation);

        Animation animation2 = getAnimation();
        if (animation2 != null) {
            animation2.cancel();
        }

        final EditText searchEditText = (EditText) findViewById(R.id.search_box);

        TranslateAnimation slideLeftAnimation2 = new TranslateAnimation(getWidth(), 0.0f, 0.0f, 0.0f);
        slideLeftAnimation2.setDuration(1000);
        slideLeftAnimation2.setFillEnabled(true);
        slideLeftAnimation2.setInterpolator(new DecelerateInterpolator(1.5f));
        slideLeftAnimation2.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ((InputMethodManager) aaruush13.tileScreenActivity.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(searchEditText, 0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        startAnimation(slideLeftAnimation2);

        setVisibility(View.VISIBLE);

        searchEditText.selectAll();
    }

    private void close() {
        isOpen = false;

        final LinearLayout tileScreenContainerLayout = (LinearLayout) aaruush13.tileScreenActivity.findViewById(R.id.tile_screen_container_layout);

        Animation animation = tileScreenContainerLayout.getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        final EditText searchEditText = (EditText) findViewById(R.id.search_box);

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
                layoutParams.setMargins(0, 0, 0, 0);
                tileScreenContainerLayout.setLayoutParams(layoutParams);

                setVisibility(View.INVISIBLE);

                ((InputMethodManager) aaruush13.tileScreenActivity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        tileScreenContainerLayout.startAnimation(slideRightAnimation);

        searchEditText.clearFocus();
    }

    public void toggle() {
        if (!isOpen) {
            open();
        } else {
            close();
        }
    }

    private void showRecentSearches() {
        final LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search_layout);

        Animation animation = searchLayout.getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        fadeOutAnimation.setDuration(150);
        fadeOutAnimation.setFillAfter(true);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                findViewById(R.id.recent).setVisibility(View.VISIBLE);

                SharedPreferences preferences = aaruush13.tileScreenActivity.getSharedPreferences(aaruush13.tileScreenActivity.getTileScreenTitle(), Context.MODE_PRIVATE);

                SearchResultBut recent1SearchResultBut = (SearchResultBut) findViewById(R.id.recent_1);
                recent1SearchResultBut.setText(preferences.getString("SearchRecent1", "No recent searches!"));
                recent1SearchResultBut.setVisibility(View.VISIBLE);

                SearchResultBut recent2SearchResultBut = (SearchResultBut) findViewById(R.id.recent_2);
                recent2SearchResultBut.setText(preferences.getString("SearchRecent2", ""));
                if (!recent2SearchResultBut.getText().toString().isEmpty()) {
                    recent2SearchResultBut.setVisibility(VISIBLE);
                }

                SearchResultBut recent3SearchResultBut = (SearchResultBut) findViewById(R.id.recent_3);
                recent3SearchResultBut.setText(preferences.getString("SearchRecent3", ""));
                if (!recent3SearchResultBut.getText().toString().isEmpty()) {
                    recent3SearchResultBut.setVisibility(VISIBLE);
                }

                findViewById(R.id.suggestions).setVisibility(View.GONE);
                findViewById(R.id.suggestion_1).setVisibility(View.GONE);
                findViewById(R.id.suggestion_2).setVisibility(View.GONE);
                findViewById(R.id.suggestion_3).setVisibility(View.GONE);
                findViewById(R.id.results).setVisibility(View.GONE);

                LinearLayout searchResultsLayout = (LinearLayout) findViewById(R.id.search_results_layout);
                searchResultsLayout.setVisibility(View.GONE);
                searchResultsLayout.removeAllViews();

                if (animation.hasEnded()) {
                    AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
                    fadeInAnimation.setDuration(150);
                    fadeInAnimation.setFillAfter(true);
                    searchLayout.startAnimation(fadeInAnimation);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        searchLayout.startAnimation(fadeOutAnimation);
    }

    private void showSearchResults(final String searchText) {
        final LinearLayout searchLayout = (LinearLayout) findViewById(R.id.search_layout);

        Animation animation = searchLayout.getAnimation();
        if (animation != null) {
            animation.cancel();
        }

        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        fadeOutAnimation.setDuration(150);
        fadeOutAnimation.setFillAfter(true);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                findViewById(R.id.recent).setVisibility(View.GONE);
                findViewById(R.id.recent_1).setVisibility(View.GONE);
                findViewById(R.id.recent_2).setVisibility(View.GONE);
                findViewById(R.id.recent_3).setVisibility(View.GONE);

                findViewById(R.id.suggestions).setVisibility(View.VISIBLE);

                LinkedList<String> suggestionResultsList = new LinkedList<String>();
                HashMap<String, LinkedList<String>> searchResultsMap = new HashMap<String, LinkedList<String>>();

                for (Map.Entry<String, String[]> searchTags : searchTagsMap.entrySet()) {
                    LinkedList<String> searchResults = new LinkedList<String>();
                    for (String searchTag : searchTags.getValue()) {
                        String searchTagLower = searchTag.toLowerCase();
                        if (suggestionResultsList.size() < 3 && searchTagLower.startsWith(searchText) && !suggestionResultsList.contains(searchTag)) {
                            suggestionResultsList.add(searchTag);
                        }
                        if (searchTagLower.contains(searchText)) {
                            searchResults.add(searchTag);
                        }
                    }
                    searchResultsMap.put(searchTags.getKey(), searchResults);
                }

                String[] suggestionResults = suggestionResultsList.toArray(new String[3]);

                SearchResultBut suggestion1SearchResultBut = (SearchResultBut) findViewById(R.id.suggestion_1);
                suggestion1SearchResultBut.setText(suggestionResults[0]);
                if (suggestion1SearchResultBut.getText().toString().isEmpty()) {
                    suggestion1SearchResultBut.setText("No suggestions!");
                }
                suggestion1SearchResultBut.setVisibility(VISIBLE);

                SearchResultBut suggestion2SearchResultBut = (SearchResultBut) findViewById(R.id.suggestion_2);
                suggestion2SearchResultBut.setText(suggestionResults[1]);
                if (!suggestion2SearchResultBut.getText().toString().isEmpty()) {
                    suggestion2SearchResultBut.setVisibility(VISIBLE);
                } else {
                    suggestion2SearchResultBut.setVisibility(GONE);
                }

                SearchResultBut suggestion3SearchResultBut = (SearchResultBut) findViewById(R.id.suggestion_3);
                suggestion3SearchResultBut.setText(suggestionResults[2]);
                if (!suggestion3SearchResultBut.getText().toString().isEmpty()) {
                    suggestion3SearchResultBut.setVisibility(VISIBLE);
                } else {
                    suggestion3SearchResultBut.setVisibility(GONE);
                }

                findViewById(R.id.results).setVisibility(View.VISIBLE);

                LinearLayout searchResultsLayout = (LinearLayout) findViewById(R.id.search_results_layout);
                searchResultsLayout.removeAllViews();
                searchResultsLayout.setVisibility(View.VISIBLE);

                for (final String tileScreenPageTitle : aaruush13.tileScreenActivity.getTileScreenPageTitles()) {
                    LinkedList<String> searchResults = searchResultsMap.get(tileScreenPageTitle);
                    if (searchResults.isEmpty()) {
                        continue;
                    }

                    TextView tileScreenPageTitleTextView = new TextView(getContext());
                    tileScreenPageTitleTextView.setPadding(aaruush13.border1 * 2, aaruush13.border3, aaruush13.border1, aaruush13.border3);
                    tileScreenPageTitleTextView.setText(tileScreenPageTitle);
                    tileScreenPageTitleTextView.setTextColor(Color.WHITE);
                    tileScreenPageTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text2);
                    searchResultsLayout.addView(tileScreenPageTitleTextView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

                    for (final String searchResult : searchResults) {
                        SearchResultBut searchResultBut = new SearchResultBut(getContext());
                        searchResultBut.setPadding(aaruush13.border1 * 3, aaruush13.border3, aaruush13.border1, aaruush13.border3);
                        searchResultBut.setText(searchResult);
                        searchResultBut.setSearchResultButListener(new SearchResultBut.SearchResultButListener() {

                            @Override
                            public boolean onClicked() {
                                if (!isOpen) {
                                    return false;
                                }
                                toggle();
                                aaruush13.tileScreenActivity.openTileScreenPage(tileScreenPageTitle, searchResult);
                                return true;
                            }

                        });
                        searchResultsLayout.addView(searchResultBut);
                    }
                }

                if (searchResultsLayout.getChildCount() == 0) {
                    SearchResultBut searchResultBut = new SearchResultBut(getContext());
                    searchResultBut.setText("No results!");
                    searchResultBut.setSearchResultButListener(new SearchResultBut.SearchResultButListener() {

                        @Override
                        public boolean onClicked() {
                            return false;
                        }

                    });
                    searchResultsLayout.addView(searchResultBut);
                }

                if (animation.hasEnded()) {
                    AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
                    fadeInAnimation.setDuration(150);
                    fadeInAnimation.setFillAfter(true);
                    searchLayout.startAnimation(fadeInAnimation);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

        });
        searchLayout.startAnimation(fadeOutAnimation);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setSearchTagsMap(HashMap<String, String[]> searchTagsMap) {
        this.searchTagsMap = searchTagsMap;
    }

}