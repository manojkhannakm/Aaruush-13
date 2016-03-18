package com.webarch.aaruush13.tiles.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;

public class GameTile extends Tile {

    public GameTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Game", 1, 1, Color.parseColor("#CC0000"), Color.parseColor("#FF4444"), R.drawable.game_icon);
    }

    @Override
    public void openTileScreen(boolean quickOpen) {
        Context context = getContext();
        context.startActivity(new Intent(context, Game.class));
    }

}