package com.webarch.aaruush13.components;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.model.GraphUser;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;
import com.webarch.aaruush13.activities.MainActivity;
import com.webarch.aaruush13.activities.TileScreenActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Tile extends RelativeLayout {

    protected Aaruush13 aaruush13;
    private String tileTitle;
    private int widthRatio, heightRatio, color1, color2, iconResId;
    private boolean isTilesAnimOn, isLayoutFinished = false, hideTitle;
    private View[] liveTiles;
    private AnimatorSet liveTileAnimatorSets;
    private int[] flipTiles;
    private ArrayList<AnimatorSet> flipTileAnimatorSets = new ArrayList<AnimatorSet>();
    private LinkedList<String> tileScreenPageTitles = new LinkedList<String>();
    private LinkedList<String> tileScreenPageClassNames = new LinkedList<String>();
    private HashMap<String, String[]> searchTagsMap = new HashMap<String, String[]>();

    protected Tile(final Context context, AttributeSet attrs, final String tileTitle, int widthRatio, int heightRatio, final int color1, final int color2, int iconResId) {
        super(context, attrs);

        this.tileTitle = tileTitle;
        this.widthRatio = widthRatio;
        this.heightRatio = heightRatio;
        this.color1 = color1;
        this.color2 = color2;
        this.iconResId = iconResId;

        aaruush13 = (Aaruush13) context.getApplicationContext();
        isTilesAnimOn = context.getSharedPreferences("MainActivity", Context.MODE_PRIVATE).getBoolean("isTilesAnimOn", true);

        LayoutInflater.from(context).inflate(R.layout.tile_layout, this, true);
        setGravity(Gravity.CENTER);
        final GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{
                color1,
                color1,
                color2
        });
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            setBackgroundDrawable(gradientDrawable);
        } else {
            setBackground(gradientDrawable);
        }
        ((ImageView) findViewById(R.id.icon)).setImageResource(iconResId);
        ((TextView) findViewById(R.id.notifications_count)).setText("  ");
        ((TextView) findViewById(R.id.tile_title)).setText(tileTitle);
        ((TextView) findViewById(R.id.tile_top_title)).setText(tileTitle);

        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (aaruush13.mainActivity.getState() != MainActivity.State.MainScreen) {
                    return;
                }

                aaruush13.mainActivity.setState(MainActivity.State.TileAnim);

                MenuPane menuPane = (MenuPane) aaruush13.mainActivity.findViewById(R.id.menu_pane);
                if (menuPane.isOpen()) {
                    menuPane.toggle();
                }

                gradientDrawable.setStroke(aaruush13.border2, color2);

                ScaleAnimation zoomOutAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                zoomOutAnimation.setDuration(100);
                zoomOutAnimation.setFillAfter(true);
                startAnimation(zoomOutAnimation);

                ScaleAnimation zoomInAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                zoomInAnimation.setDuration(100);
                zoomInAnimation.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        gradientDrawable.setStroke(0, Color.TRANSPARENT);

                        openTileScreen(false);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                });
                startAnimation(zoomInAnimation);
            }

        });
    }

    public void onPause() {
        resetTile();
    }

    public void onResume() {
        resetTile();
        setLiveTiles(liveTiles, hideTitle, true);
        setFlipTiles(flipTiles, hideTitle, true);
    }

    public void postLayout() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    //noinspection deprecation
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                isLayoutFinished = true;
                setLiveTiles(liveTiles, hideTitle, false);
                setFlipTiles(flipTiles, hideTitle, false);
            }

        });
    }

    public void setNotificationsCount(final int count) {
        final TextView notificationsCountTextView = (TextView) findViewById(R.id.notifications_count);
        notificationsCountTextView.post(new Runnable() {

            @Override
            public void run() {
                AlphaAnimation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
                fadeOutAnimation.setDuration(250);
                fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        notificationsCountTextView.setText(count > 0 ? Integer.toString(count) : "  ");

                        AlphaAnimation fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
                        fadeInAnimation.setDuration(250);
                        notificationsCountTextView.startAnimation(fadeInAnimation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                });
                notificationsCountTextView.startAnimation(fadeOutAnimation);
            }

        });
    }

    protected void setLiveTiles(View[] liveTiles, boolean hideTitle, boolean startImmediately) {
        if (flipTiles != null || liveTiles == null || liveTiles.length == 0) {
            this.liveTiles = null;
            return;
        }
        this.liveTiles = liveTiles;
        this.hideTitle = hideTitle;
        if (!isLayoutFinished || !isTilesAnimOn) {
            return;
        }

        if (!hideTitle) {
            findViewById(R.id.tile_top_title).setVisibility(VISIBLE);
            findViewById(R.id.tile_title).setVisibility(GONE);
        }

        LinkedList<View> liveTilesList = new LinkedList<View>();
        liveTilesList.add(findViewById(R.id.tile_container_layout));
        for (int i = 0; i < liveTiles.length; i++) {
            liveTiles[i].setVisibility(INVISIBLE);
            addView(liveTiles[i], i + 1, liveTiles[i].getLayoutParams() != null ? liveTiles[i].getLayoutParams() : new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            liveTilesList.add(liveTiles[i]);
        }

        LinkedList<Animator> liveTileAnimators = new LinkedList<Animator>();
        for (int i = 0; i < liveTilesList.size() - 1; i++) {
            liveTileAnimators.add(getLiveTileAnimatorSet(liveTilesList.get(i), liveTilesList.get(i + 1)));
        }
        liveTileAnimators.add(getLiveTileAnimatorSet(liveTilesList.get(liveTilesList.size() - 1), liveTilesList.get(0)));
        liveTileAnimators.get(0).setStartDelay(startImmediately ? 0 : 2500 + new Random().nextInt(2500));

        liveTileAnimatorSets = new AnimatorSet();
        liveTileAnimatorSets.playSequentially(liveTileAnimators);
        liveTileAnimatorSets.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                for (Animator liveTileAnimator : liveTileAnimatorSets.getChildAnimations()) {
                    liveTileAnimator.setStartDelay(2500 + new Random().nextInt(2500));
                }
                liveTileAnimatorSets.start();
            }

        });
        liveTileAnimatorSets.start();
    }

    private AnimatorSet getLiveTileAnimatorSet(final View outView, final View inView) {
        ObjectAnimator slideOutAnimator = ObjectAnimator.ofFloat(outView, "y", 0.0f, -getHeight()).setDuration(500);
        slideOutAnimator.setInterpolator(new DecelerateInterpolator(1.5f));

        ObjectAnimator slideInAnimator = ObjectAnimator.ofFloat(inView, "y", getHeight(), 0.0f).setDuration(500);
        slideInAnimator.setInterpolator(new DecelerateInterpolator(1.5f));
        slideInAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                outView.setVisibility(INVISIBLE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                inView.setVisibility(VISIBLE);
            }

        });

        AnimatorSet liveTileAnimatorSet = new AnimatorSet();
        liveTileAnimatorSet.play(slideOutAnimator).with(slideInAnimator);
        liveTileAnimatorSet.setStartDelay(2500 + new Random().nextInt(2500));
        return liveTileAnimatorSet;
    }

    protected void setFlipTiles(int[] flipTiles, boolean hideTitle, boolean startImmediately) {
        if (liveTiles != null || flipTiles == null || flipTiles.length < 5) {
            this.flipTiles = null;
            return;
        }
        this.flipTiles = flipTiles;
        this.hideTitle = hideTitle;
        if (!isLayoutFinished || !isTilesAnimOn) {
            return;
        }

        if (!hideTitle) {
            findViewById(R.id.tile_top_title).setVisibility(VISIBLE);
            findViewById(R.id.tile_title).setVisibility(GONE);
        }

        LinearLayout flipTileLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.flip_tile_layout, null, false);
        addView(flipTileLayout, 1, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        addFlipTileAnimation((ImageView) flipTileLayout.findViewById(R.id.flip_tile_1), 0, flipTiles, startImmediately);
        addFlipTileAnimation((ImageView) flipTileLayout.findViewById(R.id.flip_tile_2), 1, flipTiles, startImmediately);
        addFlipTileAnimation((ImageView) flipTileLayout.findViewById(R.id.flip_tile_3), 2, flipTiles, startImmediately);
        addFlipTileAnimation((ImageView) flipTileLayout.findViewById(R.id.flip_tile_4), 3, flipTiles, startImmediately);
    }

    private void addFlipTileAnimation(final ImageView imageView, final int imageViewIndex, final int[] flipTiles, boolean startImmediately) {
        final AnimatorSet flipTileAnimatorSet = new AnimatorSet();

        ObjectAnimator flip90Animator = ObjectAnimator.ofFloat(imageView, "rotationX", 0.0f, 90.0f).setDuration(250);
        flip90Animator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                int flipTileIndex = new Random().nextInt(flipTiles.length - 5), temp;
                temp = flipTiles[flipTileIndex];
                flipTiles[flipTileIndex] = flipTiles[flipTiles.length - 4 + imageViewIndex];
                flipTiles[flipTiles.length - 4 + imageViewIndex] = temp;

                imageView.setImageResource(temp);
            }

        });

        ObjectAnimator flip360Animator = ObjectAnimator.ofFloat(imageView, "rotationX", 270.0f, 360.0f).setDuration(250);
        flip360Animator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                flipTileAnimatorSet.setStartDelay(2500 + new Random().nextInt(2500));
                flipTileAnimatorSet.start();
            }

        });

        flipTileAnimatorSet.playSequentially(flip90Animator, flip360Animator);
        flipTileAnimatorSet.setStartDelay(startImmediately ? new Random().nextInt(1000) : 2500 + new Random().nextInt(2500));
        flipTileAnimatorSet.setInterpolator(new DecelerateInterpolator(1.5f));
        flipTileAnimatorSet.start();

        flipTileAnimatorSets.add(flipTileAnimatorSet);
    }

    public void resetTile() {
        if (liveTiles == null && flipTiles == null) {
            return;
        }

        if (liveTileAnimatorSets != null) {
            liveTileAnimatorSets.removeAllListeners();
            for (Animator liveTileAnimator : liveTileAnimatorSets.getChildAnimations()) {
                AnimatorSet liveTileAnimatorSet = (AnimatorSet) liveTileAnimator;
                for (Animator liveTileAnimator2 : liveTileAnimatorSet.getChildAnimations()) {
                    liveTileAnimator2.end();
                }
                liveTileAnimatorSet.end();
            }
            liveTileAnimatorSets.end();
            liveTileAnimatorSets = null;
        }

        if (!flipTileAnimatorSets.isEmpty()) {
            for (AnimatorSet flipTileAnimatorSet : flipTileAnimatorSets) {
                flipTileAnimatorSet.getChildAnimations().get(1).removeAllListeners();
                flipTileAnimatorSet.end();
            }
            flipTileAnimatorSets.clear();
        }

        CharSequence notificationsCountText = ((TextView) findViewById(R.id.notifications_count)).getText();
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(R.layout.tile_layout, this, true);
        ((ImageView) findViewById(R.id.icon)).setImageResource(iconResId);
        ((TextView) findViewById(R.id.notifications_count)).setText(notificationsCountText);
        ((TextView) findViewById(R.id.tile_title)).setText(tileTitle);
        ((TextView) findViewById(R.id.tile_top_title)).setText(tileTitle);
    }

    public void toggleAnim(boolean isTilesAnimOn) {
        this.isTilesAnimOn = isTilesAnimOn;

        resetTile();
        setLiveTiles(liveTiles, hideTitle, true);
        setFlipTiles(flipTiles, hideTitle, true);
    }

    public void facebookLoggedIn(GraphUser graphUser) {
    }

    public void facebookLoggedOut() {
    }

    protected void openTileScreen(boolean quickOpen) {
        aaruush13.mainActivity.setState(MainActivity.State.TileAnim);

        Intent intent = new Intent(getContext(), TileScreenActivity.class);
        intent.putExtra("tileId", getId());
        intent.putExtra("tileScreenTitle", tileTitle);
        intent.putExtra("color1", color1);
        intent.putExtra("color2", color2);
        intent.putExtra("iconResId", iconResId);
        intent.putExtra("notificationsCount", ((TextView) findViewById(R.id.notifications_count)).getText());
        intent.putExtra("width", getWidth());
        intent.putExtra("height", getHeight());
        Point tileLocation = aaruush13.mainActivity.getTileLocation(this);
        intent.putExtra("marginLeft", tileLocation.x);
        intent.putExtra("marginTop", tileLocation.y);
        intent.putExtra("tileScreenPageTitles", tileScreenPageTitles.toArray(new String[tileScreenPageTitles.size()]));
        intent.putExtra("tileScreenPageClassNames", tileScreenPageClassNames.toArray(new String[tileScreenPageClassNames.size()]));
        intent.putExtra("searchTagsMap", searchTagsMap);
        intent.putExtra("curTileScreenPageIndex", 0);
        intent.putExtra("quickOpen", quickOpen);
        getContext().startActivity(intent);
    }

    protected void addTileScreenPage(String tileScreenPageTitle, Class tileScreenPageClass, String[] searchTags) {
        tileScreenPageTitles.add(tileScreenPageTitle);
        tileScreenPageClassNames.add(tileScreenPageClass.getName());
        searchTagsMap.put(tileScreenPageTitle, searchTags);
    }

    public int getWidthRatio() {
        return widthRatio;
    }

    public int getHeightRatio() {
        return heightRatio;
    }

    public HashMap<String, String[]> getSearchTagsMap() {
        return searchTagsMap;
    }

}