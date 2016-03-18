package com.webarch.aaruush13.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.NavPane;
import com.webarch.aaruush13.components.SearchPane;
import com.webarch.aaruush13.components.TileScreenPage;
import com.webarch.aaruush13.components.TileScreenPageAdapter;

import java.util.HashMap;

public class TileScreenActivity extends FragmentActivity {

    private Aaruush13 aaruush13;
    private State state;
    private boolean isInForeground = false;
    private String tileScreenTitle, tileScreenPageSearchResult;
    private int color1, color2, curTileScreenPageIndex;
    private String[] tileScreenPageTitles;
    private TileScreenPageAdapter tileScreenPageAdapter;

    @Override
    public void onBackPressed() {
        NavPane navPane = (NavPane) findViewById(R.id.nav_pane);
        SearchPane searchPane = (SearchPane) findViewById(R.id.search_pane);
        TileScreenPage tileScreenPage = getTileScreenPage(curTileScreenPageIndex);

        if (navPane.isOpen()) {
            navPane.toggle();
        } else if (searchPane.isOpen()) {
            searchPane.toggle();
        } else if (tileScreenPage.isBackKeyEnabled()) {
            tileScreenPage.onBackPressed();
        } else {
            if (getIntent().getBooleanExtra("quickOpen", true)) {
                quickClose();
            } else {
                close();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aaruush13 = (Aaruush13) getApplication();
        aaruush13.tileScreenActivity = this;

        state = savedInstanceState == null ? State.TileAnim : State.getState(savedInstanceState.getInt("state"));

        Intent intent = getIntent();
        tileScreenTitle = intent.getStringExtra("tileScreenTitle");
        color1 = intent.getIntExtra("color1", 0);
        color2 = intent.getIntExtra("color2", 0);
        curTileScreenPageIndex = intent.getIntExtra("curTileScreenPageIndex", 0);

        setContentView(R.layout.tile_screen_layout);

        ViewPager tileScreenPagesViewPager = (ViewPager) findViewById(R.id.tile_screen_pager);
        tileScreenPageTitles = intent.getStringArrayExtra("tileScreenPageTitles");
        tileScreenPageAdapter = new TileScreenPageAdapter(this, getSupportFragmentManager(), tileScreenPageTitles, intent.getStringArrayExtra("tileScreenPageClassNames"));
        tileScreenPagesViewPager.setAdapter(tileScreenPageAdapter);

        findViewById(R.id.tile_screen_layout).setBackgroundColor(color1);

        final NavPane navPane = (NavPane) findViewById(R.id.nav_pane);
        for (String tileScreenPageTitle : tileScreenPageTitles) {
            navPane.addNavPaneBut(tileScreenPageTitle);
        }

        final SearchPane searchPane = (SearchPane) findViewById(R.id.search_pane);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) searchPane.getLayoutParams();
        //noinspection deprecation
        layoutParams.width = (int) (getWindowManager().getDefaultDisplay().getWidth() * (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? 0.75f : 0.5f));
        searchPane.setLayoutParams(layoutParams);
        searchPane.setSearchTagsMap((HashMap<String, String[]>) intent.getSerializableExtra("searchTagsMap"));

        findViewById(R.id.title_bar).setBackgroundColor(color2);

        ImageView navPaneBut = (ImageView) findViewById(R.id.nav_pane_but);
        if (tileScreenPageAdapter.getCount() > 1) {
            navPaneBut.setVisibility(View.VISIBLE);
            navPaneBut.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    navPane.toggle();
                }

            });
        }

        ((TextView) findViewById(R.id.tile_screen_title)).setText(tileScreenTitle);

        findViewById(R.id.search_pane_but).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                searchPane.toggle();
            }

        });

        tileScreenPagesViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                navPane.getNavPaneBut(curTileScreenPageIndex).setClicked(false);
                navPane.getNavPaneBut(position).setClicked(true);

                final TileScreenPage tileScreenPage = getTileScreenPage(position);
                if (tileScreenPage != null) {
                    tileScreenPage.setOnOpenRunnable(new Runnable() {

                        @Override
                        public void run() {
                            tileScreenPage.onOpen(false);
                            if (tileScreenPageSearchResult != null) {
                                tileScreenPage.onSearch(tileScreenPageSearchResult);
                                tileScreenPageSearchResult = null;
                            }
                        }

                    });
                }

                curTileScreenPageIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });

        PagerTitleStrip tileScreenPageTabs = (PagerTitleStrip) findViewById(R.id.tile_screen_page_tabs);
        if (tileScreenPageAdapter.getCount() > 1) {
            tileScreenPageTabs.setVisibility(View.VISIBLE);
            tileScreenPageTabs.setTextColor(color2);
            tileScreenPageTabs.setNonPrimaryAlpha(0.3f);
        }

        if (savedInstanceState != null) {
            curTileScreenPageIndex = savedInstanceState.getInt("curTileScreenPageIndex");
            navPane.setIsOpen(savedInstanceState.getBoolean("isNavPaneOpen", false));
            searchPane.setIsOpen(savedInstanceState.getBoolean("isSearchPaneOpen", false));
        }

        final LinearLayout tileScreenContainerLayout = (LinearLayout) findViewById(R.id.tile_screen_container_layout);

        if (navPane.isOpen()) {
            navPane.setVisibility(View.VISIBLE);

            navPane.post(new Runnable() {

                @Override
                public void run() {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tileScreenContainerLayout.getLayoutParams();
                    layoutParams.setMargins(navPane.getWidth(), 0, -navPane.getWidth(), 0);
                    tileScreenContainerLayout.setLayoutParams(layoutParams);
                }

            });
        }

        if (searchPane.isOpen()) {
            searchPane.setVisibility(View.VISIBLE);

            searchPane.post(new Runnable() {

                @Override
                public void run() {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tileScreenContainerLayout.getLayoutParams();
                    layoutParams.setMargins(-searchPane.getWidth(), 0, searchPane.getWidth(), 0);
                    tileScreenContainerLayout.setLayoutParams(layoutParams);
                }

            });
        }

        if (savedInstanceState != null ? savedInstanceState.getBoolean("quickOpen", true) : intent.getBooleanExtra("quickOpen", true)) {
            quickOpen();
        } else {
            open();
        }
    }

//	@Override
//	protected void onDestroy() {
//		super.onDestroy();
//
//		aaruush13.tileScreenActivity = null;
//	}

    @Override
    protected void onPause() {
        isInForeground = false;

        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        isInForeground = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("state", state.getValue());
        outState.putBoolean("quickOpen", true);
        outState.putInt("curTileScreenPageIndex", curTileScreenPageIndex);
        outState.putBoolean("isNavPaneOpen", ((NavPane) findViewById(R.id.nav_pane)).isOpen());
        outState.putBoolean("isSearchPaneOpen", ((SearchPane) findViewById(R.id.search_pane)).isOpen());
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && !((SearchPane) findViewById(R.id.search_pane)).isOpen()) {
            ((NavPane) findViewById(R.id.nav_pane)).toggle();
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return state == State.TileScreen && super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return state == State.TileScreen && super.dispatchTouchEvent(ev);
    }

    private void quickOpen() {
        state = State.TileAnim;

        final RelativeLayout tileScreenLayout = (RelativeLayout) findViewById(R.id.tile_screen_layout);
        tileScreenLayout.setVisibility(View.VISIBLE);
        findViewById(R.id.tile_anim_container_layout).setVisibility(View.GONE);

        if (aaruush13.mainActivity != null) {
            aaruush13.mainActivity.setState(MainActivity.State.MainScreen);
        }
        state = State.TileScreen;
    }

    private void open() {
        state = State.TileAnim;

        Intent intent = getIntent();

        final RelativeLayout tileClone = new RelativeLayout(this);
        LayoutInflater.from(this).inflate(R.layout.tile_layout, tileClone, true);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{
                color1,
                color1,
                color2
        });
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            tileClone.setBackgroundDrawable(gradientDrawable);
        } else {
            tileClone.setBackground(gradientDrawable);
        }
        ((ImageView) tileClone.findViewById(R.id.icon)).setImageResource(intent.getIntExtra("iconResId", 0));
        ((TextView) tileClone.findViewById(R.id.notifications_count)).setText(intent.getStringExtra("notificationsCount"));
        ((TextView) tileClone.findViewById(R.id.tile_title)).setText(tileScreenTitle);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(intent.getIntExtra("width", 0), intent.getIntExtra("height", 0));
        layoutParams.setMargins(intent.getIntExtra("marginLeft", 0), intent.getIntExtra("marginTop", 0), -intent.getIntExtra("marginLeft", 0), 0);
        tileClone.setLayoutParams(layoutParams);

        final RelativeLayout tileAnimContainerLayout = (RelativeLayout) findViewById(R.id.tile_anim_container_layout);
        tileAnimContainerLayout.addView(tileClone);

        tileClone.post(new Runnable() {

            @Override
            public void run() {
                if (aaruush13.mainActivity != null) {
                    aaruush13.mainActivity.findViewById(getIntent().getIntExtra("tileId", 0)).setVisibility(View.INVISIBLE);

                    ObjectAnimator.ofFloat(aaruush13.mainActivity.findViewById(R.id.main_screen_container_layout), "alpha", 1.0f, 0.0f).setDuration(500).start();
                }

                AnimatorSet slideAnimatorSet = new AnimatorSet();
                slideAnimatorSet.play(ObjectAnimator.ofFloat(tileClone, "x", tileClone.getLeft(), (tileAnimContainerLayout.getWidth() - tileClone.getWidth()) / 2.0f)).with(ObjectAnimator.ofFloat(tileClone, "y", tileClone.getTop(), (tileAnimContainerLayout.getHeight() - tileClone.getHeight()) / 2.0f));
                slideAnimatorSet.setDuration(300);
                slideAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                slideAnimatorSet.start();

                AnimatorSet flipAnimatorSet = new AnimatorSet();
                flipAnimatorSet.playSequentially(ObjectAnimator.ofFloat(tileClone, "rotationY", 0.0f, 90.0f).setDuration(150), ObjectAnimator.ofFloat(tileClone.findViewById(R.id.tile_container_layout), "alpha", 1.0f, 0.0f).setDuration(0), ObjectAnimator.ofFloat(tileClone, "rotationY", 90.0f, 180.0f).setDuration(150));
                flipAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                flipAnimatorSet.start();

                AnimatorSet zoomInAnimatorSet = new AnimatorSet();
                zoomInAnimatorSet.play(ObjectAnimator.ofFloat(tileClone, "scaleX", 1.0f, ((float) tileAnimContainerLayout.getWidth()) / tileClone.getWidth())).with(ObjectAnimator.ofFloat(tileClone, "scaleY", 1.0f, ((float) tileAnimContainerLayout.getHeight()) / tileClone.getHeight()));
                zoomInAnimatorSet.setStartDelay(200);
                zoomInAnimatorSet.setDuration(300);
                zoomInAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                zoomInAnimatorSet.start();

                final RelativeLayout tileScreenLayout = (RelativeLayout) findViewById(R.id.tile_screen_layout);
                ObjectAnimator fadeInAnimator = ObjectAnimator.ofFloat(tileScreenLayout, "alpha", 0.0f, 1.0f);
                fadeInAnimator.setStartDelay(500);
                fadeInAnimator.setDuration(250);
                fadeInAnimator.addListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        state = State.TileScreen;

                        if (aaruush13.mainActivity != null) {
                            aaruush13.mainActivity.setState(MainActivity.State.MainScreen);

                            aaruush13.mainActivity.findViewById(getIntent().getIntExtra("tileId", 0)).setVisibility(View.VISIBLE);

                            ObjectAnimator.ofFloat(aaruush13.mainActivity.findViewById(R.id.main_screen_container_layout), "alpha", 0.0f, 1.0f).setDuration(0).start();
                        }

                        tileAnimContainerLayout.setVisibility(View.GONE);

                        tileScreenLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                            @Override
                            public void onGlobalLayout() {
                                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                    //noinspection deprecation
                                    tileScreenLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                } else {
                                    tileScreenLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                }

                                if (tileScreenPageAdapter.getCount() == 0) {
                                    return;
                                }

                                ((NavPane) findViewById(R.id.nav_pane)).getNavPaneBut(curTileScreenPageIndex).setBackgroundColor(color2);

                                ViewPager tileScreenPagesViewPager = (ViewPager) findViewById(R.id.tile_screen_pager);
                                if (tileScreenPagesViewPager.getCurrentItem() != curTileScreenPageIndex) {
                                    tileScreenPagesViewPager.setCurrentItem(curTileScreenPageIndex);
                                } else {
                                    final TileScreenPage tileScreenPage = getTileScreenPage(curTileScreenPageIndex);
                                    if (tileScreenPage != null) {
                                        tileScreenPage.setOnOpenRunnable(new Runnable() {

                                            @Override
                                            public void run() {
                                                tileScreenPage.onOpen(false);
                                            }

                                        });
                                    }
                                }
                            }

                        });
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {//TODO: StartOffset not working
                        tileScreenLayout.setVisibility(View.VISIBLE);
                    }

                });
                fadeInAnimator.start();
            }

        });
    }

    private void quickClose() {
        state = State.TileAnim;

        finish();
    }

    private void close() {
        state = State.TileAnim;

        if (aaruush13.mainActivity != null) {
            ObjectAnimator.ofFloat(aaruush13.mainActivity.findViewById(R.id.main_screen_container_layout), "alpha", 1.0f, 0.0f).setDuration(0).start();
        }

        RelativeLayout tileScreenLayout = (RelativeLayout) findViewById(R.id.tile_screen_layout);
        AnimatorProxy.wrap(tileScreenLayout).setPivotX(tileScreenLayout.getWidth() * 0.5f);
        AnimatorProxy.wrap(tileScreenLayout).setPivotY(tileScreenLayout.getHeight() * 0.1f);
        AnimatorSet zoomOutAnimatorSet = new AnimatorSet();
        zoomOutAnimatorSet.play(ObjectAnimator.ofFloat(tileScreenLayout, "scaleX", 1.0f, 0.5f)).with(ObjectAnimator.ofFloat(tileScreenLayout, "scaleY", 1.0f, 0.5f));
        zoomOutAnimatorSet.setDuration(200);
        zoomOutAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        zoomOutAnimatorSet.start();

        AnimatorSet slideDownAnimatorSet = new AnimatorSet();
        AnimatorSet.Builder slideDownAnimatorSetBuilder = slideDownAnimatorSet.play(ObjectAnimator.ofFloat(tileScreenLayout, "y", 0, tileScreenLayout.getHeight())).with(ObjectAnimator.ofFloat(tileScreenLayout, "scaleX", 0.5f, 0.0f)).with(ObjectAnimator.ofFloat(tileScreenLayout, "scaleY", 0.5f, 0.0f)).with(ObjectAnimator.ofFloat(tileScreenLayout, "alpha", 1.0f, 0.0f));
        if (aaruush13.mainActivity != null) {
            slideDownAnimatorSetBuilder.with(ObjectAnimator.ofFloat(aaruush13.mainActivity.findViewById(R.id.main_screen_container_layout), "alpha", 0.0f, 1.0f));
        }
        slideDownAnimatorSet.setStartDelay(200);
        slideDownAnimatorSet.setDuration(300);
        slideDownAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        slideDownAnimatorSet.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                finish();
            }

        });
        slideDownAnimatorSet.start();
    }

    private int getIndexOf(String tileScreenPageTitle) {
        for (int i = 0; i < tileScreenPageTitles.length; i++) {
            if (tileScreenPageTitles[i].equals(tileScreenPageTitle)) {
                return i;
            }
        }
        return -1;
    }

    public TileScreenPage getTileScreenPage(int index) {
        return tileScreenPageAdapter.getTileScreenPages()[index];
    }

    public TileScreenPage getTileScreenPage(String tileScreenPageTitle) {
        return getTileScreenPage(getIndexOf(tileScreenPageTitle));
    }

    public void openTileScreenPage(String tileScreenPageTitle, String tileScreenPageSearchResult) {
        int tileScreenPageIndex = getIndexOf(tileScreenPageTitle);
        if (tileScreenPageIndex != curTileScreenPageIndex) {
            this.tileScreenPageSearchResult = tileScreenPageSearchResult;
            ((ViewPager) findViewById(R.id.tile_screen_pager)).setCurrentItem(tileScreenPageIndex, true);
        } else {
            getTileScreenPage(curTileScreenPageIndex).onSearch(tileScreenPageSearchResult);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isInForeground() {
        return isInForeground;
    }

    public String getTileScreenTitle() {
        return tileScreenTitle;
    }

    public int getColor1() {
        return color1;
    }

    public int getColor2() {
        return color2;
    }

    public String[] getTileScreenPageTitles() {
        return tileScreenPageTitles;
    }

    public enum State {

        TileAnim(0), TileScreen(1);
        private int value;

        private State(int value) {
            this.value = value;
        }

        public static State getState(int value) {
            for (State state : State.values()) {
                if (state.getValue() == value) {
                    return state;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }

    }

}