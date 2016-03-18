package com.webarch.aaruush13.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.FacebookLogin;
import com.webarch.aaruush13.components.LoadingView;
import com.webarch.aaruush13.components.MenuPane;
import com.webarch.aaruush13.components.Tile;
import com.webarch.aaruush13.gcm.CloudMessaging;

import java.util.Random;

public class MainActivity extends Activity implements Session.StatusCallback {

    private Aaruush13 aaruush13;
    private State state;
    private boolean isInForeground = false;
    private CloudMessaging cloudMessaging;
    private UiLifecycleHelper uiLifecycleHelper;
    private float splashY;
    private TranslateAnimation splashAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aaruush13 = (Aaruush13) getApplication();
        aaruush13.mainActivity = this;

        state = savedInstanceState == null ? State.Loading : State.getState(savedInstanceState.getInt("state"));//TODO: Change state to loading later

        setContentView(R.layout.main_layout);

        cloudMessaging = new CloudMessaging(this);

        uiLifecycleHelper = new UiLifecycleHelper(this, this);
        uiLifecycleHelper.onCreate(savedInstanceState);

        final RelativeLayout tilesLayout = (RelativeLayout) findViewById(R.id.tiles_layout);
        tilesLayout.post(new Runnable() {

            @Override
            public void run() {
                boolean isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
                int tileDimen = (tilesLayout.getHeight() - aaruush13.border2 * 2) / (isPortrait ? 3 : 2) - aaruush13.border2 * 2, totalWidth = aaruush13.border2 * 2;
                for (int i = 0; i < tilesLayout.getChildCount(); i++) {
                    Tile tile = (Tile) tilesLayout.getChildAt(i);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tile.getLayoutParams();
                    layoutParams.width = tileDimen * tile.getWidthRatio() + aaruush13.border2 * (tile.getWidthRatio() - 1) * 2;
                    layoutParams.height = tileDimen * tile.getHeightRatio() + aaruush13.border2 * (tile.getHeightRatio() - 1) * 2;
                    layoutParams.setMargins(aaruush13.border2, aaruush13.border2, aaruush13.border2, aaruush13.border2);
                    tile.setLayoutParams(layoutParams);
                    tile.postLayout();
                    totalWidth += isPortrait ? (i < 5 ? layoutParams.width + aaruush13.border1 : 0) : (i < 7 ? layoutParams.width + aaruush13.border1 : 0);//TODO: Change 3 & 4 according to no. of tiles on 1st row of each layout
                }
                tilesLayout.setLayoutParams(new FrameLayout.LayoutParams(totalWidth, FrameLayout.LayoutParams.MATCH_PARENT));
            }

        });

        MenuPane menuPane = (MenuPane) findViewById(R.id.menu_pane);
        final FacebookLogin facebookLogin = (FacebookLogin) findViewById(R.id.facebook_login);

        menuPane.addMenuPaneBut("Facebook", R.drawable.menu_facebook, R.drawable.menu_facebook_touched, new MenuPane.MenuPaneButListener() {

            @Override
            public void onTouched(MenuPane.MenuPaneBut menuPaneBut) {
                facebookLogin.open();
            }

        });
        if (getSharedPreferences("MainActivity", MODE_PRIVATE).getBoolean("isTilesAnimOn", true)) {
            menuPane.addMenuPaneBut("Off live tiles", R.drawable.menu_tiles_anim_off, R.drawable.menu_tiles_anim_off_touched, new MenuPane.MenuPaneButListener() {

                @Override
                public void onTouched(MenuPane.MenuPaneBut menuPaneBut) {
                    toggleTilesAnimation(menuPaneBut);
                }

            });
        } else {
            menuPane.addMenuPaneBut("On live tiles", R.drawable.menu_tiles_anim_on, R.drawable.menu_tiles_anim_on_touched, new MenuPane.MenuPaneButListener() {

                @Override
                public void onTouched(MenuPane.MenuPaneBut menuPaneBut) {
                    toggleTilesAnimation(menuPaneBut);
                }

            });
        }

        Session session = Session.getActiveSession();
        if (session != null && session.isOpened()) {
            facebookLogin.loggedIn();
        }

        if (savedInstanceState != null) {
            facebookLogin.setIsOpen(savedInstanceState.getBoolean("isFacebookLoginOpen", false));
            menuPane.setIsOpen(savedInstanceState.getBoolean("isMenuPaneOpen", false));
        }
        if (facebookLogin.isOpen()) {
            facebookLogin.setVisibility(View.VISIBLE);
        }
        if (menuPane.isOpen()) {
            menuPane.setVisibility(View.VISIBLE);
        }

        final RelativeLayout splashScreenLayout = (RelativeLayout) findViewById(R.id.splash_screen_layout);
        final View.OnTouchListener swipeUpTouchListener = new

                View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View view, MotionEvent ev) {
                        float y = ev.getRawY();
                        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) splashScreenLayout.getLayoutParams();
                        switch (ev.getActionMasked()) {
                            case MotionEvent.ACTION_DOWN:
                                if (splashAnimation != null) {
                                    splashAnimation.setAnimationListener(null);
                                    splashAnimation.cancel();
                                }
                                splashY = y;
                                break;
                            case MotionEvent.ACTION_MOVE:
                                int dy = (int) (y - splashY);
                                if (dy > 0) {
                                    break;
                                }
                                layoutParams.topMargin = dy;
                                layoutParams.bottomMargin = -dy;
                                splashScreenLayout.setLayoutParams(layoutParams);
                                break;
                            case MotionEvent.ACTION_UP:
                                if (-layoutParams.topMargin < splashScreenLayout.getHeight() * 0.25f) {
                                    splashAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -layoutParams.topMargin);
                                    splashAnimation.setDuration(1000);
                                    splashAnimation.setFillEnabled(true);
                                    splashAnimation.setInterpolator(new BounceInterpolator());
                                    splashAnimation.setAnimationListener(new Animation.AnimationListener() {

                                        @Override
                                        public void onAnimationStart(Animation animation) {
                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                            layoutParams.topMargin = 0;
                                            layoutParams.bottomMargin = 0;
                                            splashScreenLayout.setLayoutParams(layoutParams);
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {
                                        }

                                    });
                                    splashScreenLayout.startAnimation(splashAnimation);
                                } else {
                                    splashScreenLayout.setOnTouchListener(null);

                                    splashAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -splashScreenLayout.getHeight() - layoutParams.topMargin);
                                    splashAnimation.setDuration(1000);
                                    splashAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
                                    splashAnimation.setAnimationListener(new Animation.AnimationListener() {

                                        @Override
                                        public void onAnimationStart(Animation animation) {
                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                            splashScreenLayout.setVisibility(View.GONE);

                                            state = State.MainScreen;
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {
                                        }

                                    });
                                    splashScreenLayout.startAnimation(splashAnimation);
                                }
                        }
                        return true;
                    }

                };

        final RelativeLayout mainScreenLayout = (RelativeLayout) findViewById(R.id.main_screen_layout);
        final LoadingView loadingView = (LoadingView) findViewById(R.id.loading);
        final ImageView swipeupImageView = (ImageView) findViewById(R.id.swipeup);
        switch (state) {
            case Loading:
                int startOffset = 500 + new Random().nextInt(500);

                AlphaAnimation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
                fadeOutAnimation.setStartOffset(startOffset);
                fadeOutAnimation.setDuration(500);
                fadeOutAnimation.setFillAfter(true);
                loadingView.startAnimation(fadeOutAnimation);

                AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
                fadeInAnimation.setStartOffset(startOffset);
                fadeInAnimation.setDuration(500);
                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {//TODO: StartOffset not working
                        swipeupImageView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        loadingView.setVisibility(View.INVISIBLE);
                        mainScreenLayout.setVisibility(View.VISIBLE);
                        splashScreenLayout.setOnTouchListener(swipeUpTouchListener);

                        state = State.Loaded;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                });
                swipeupImageView.startAnimation(fadeInAnimation);
                break;
            case Loaded:
                loadingView.setVisibility(View.INVISIBLE);
                swipeupImageView.setVisibility(View.VISIBLE);
                mainScreenLayout.setVisibility(View.VISIBLE);
                splashScreenLayout.setOnTouchListener(swipeUpTouchListener);
                break;
            default:
                splashScreenLayout.setVisibility(View.GONE);
                mainScreenLayout.setVisibility(View.VISIBLE);
                state = State.MainScreen;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        isInForeground = true;

        uiLifecycleHelper.onResume();

        for (Tile tile : getTiles()) {
            tile.onResume();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("state", state.getValue());
        outState.putBoolean("isMenuPaneOpen", ((MenuPane) findViewById(R.id.menu_pane)).isOpen());
        outState.putBoolean("isFacebookLoginOpen", ((FacebookLogin) findViewById(R.id.facebook_login)).isOpen());

        uiLifecycleHelper.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        isInForeground = false;

        uiLifecycleHelper.onPause();

        for (Tile tile : getTiles()) {
            tile.onPause();
        }

        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        cloudMessaging.onDestroy();

        uiLifecycleHelper.onDestroy();

        aaruush13.mainActivity = null;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && !((FacebookLogin) findViewById(R.id.facebook_login)).isOpen()) {
            ((MenuPane) findViewById(R.id.menu_pane)).toggle();
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        FacebookLogin facebookLogin = (FacebookLogin) findViewById(R.id.facebook_login);
        MenuPane menuPane = (MenuPane) findViewById(R.id.menu_pane);

        if (facebookLogin.isOpen()) {
            facebookLogin.close();
        } else if (menuPane.isOpen()) {
            menuPane.toggle();
        } else {
            state = State.Loading;
            super.onBackPressed();
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return state.getValue() <= 2 && super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return state.getValue() <= 2 && super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uiLifecycleHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void call(Session session, SessionState state, Exception exception) {
        FacebookLogin facebookLogin = (FacebookLogin) findViewById(R.id.facebook_login);
        if (session.isOpened()) {
            facebookLogin.loggedIn();
        } else if (session.isClosed()) {
            facebookLogin.loggedOut();
        }
    }

    private void toggleTilesAnimation(MenuPane.MenuPaneBut tilesAnimMenuPaneBut) {
        SharedPreferences preferences = getSharedPreferences("MainActivity", MODE_PRIVATE);
        final boolean isTilesAnimOn = !preferences.getBoolean("isTilesAnimOn", true);
        preferences.edit().putBoolean("isTilesAnimOn", isTilesAnimOn).commit();

        if (isTilesAnimOn) {
            tilesAnimMenuPaneBut.init("Off live tiles", R.drawable.menu_tiles_anim_off, R.drawable.menu_tiles_anim_off_touched, new MenuPane.MenuPaneButListener() {

                @Override
                public void onTouched(MenuPane.MenuPaneBut menuPaneBut) {
                    toggleTilesAnimation(menuPaneBut);
                }

            });
        } else {
            tilesAnimMenuPaneBut.init("On live tiles", R.drawable.menu_tiles_anim_on, R.drawable.menu_tiles_anim_on_touched, new MenuPane.MenuPaneButListener() {

                @Override
                public void onTouched(MenuPane.MenuPaneBut menuPaneBut) {
                    toggleTilesAnimation(menuPaneBut);
                }

            });
        }

        for (Tile tile : getTiles()) {
            tile.toggleAnim(isTilesAnimOn);
        }
    }

    public Tile[] getTiles() {
        RelativeLayout tilesLayout = (RelativeLayout) findViewById(R.id.tiles_layout);
        Tile[] tiles = new Tile[tilesLayout.getChildCount()];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = (Tile) tilesLayout.getChildAt(i);
        }
        return tiles;
    }

    public Point getTileLocation(Tile tile) {
        int[] x = new int[2];
        tile.getLocationInWindow(x);

        View view = tile;
        LinearLayout mainScreenContainerLayout = (LinearLayout) findViewById(R.id.main_screen_container_layout);
        int y = 0;
        while (view != mainScreenContainerLayout) {
            y += view.getTop();
            view = (View) view.getParent();
        }

        return new Point(x[0], y);
    }

    public boolean isInForeground() {
        return isInForeground;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {

        Loading(0), Loaded(1), MainScreen(2), TileAnim(3);
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