package com.webarch.aaruush13.tiles.notifications;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.webarch.aaruush13.R;
import com.webarch.aaruush13.components.Tile;

public class NotificationsTile extends Tile {

    public NotificationsTile(Context context, AttributeSet attrs) {
        super(context, attrs, "Notifications", 2, 1, Color.parseColor("#669900"), Color.parseColor("#99CC00"), R.drawable.notifications_icon);

        int unreadCount = context.getSharedPreferences("Notifications", Context.MODE_PRIVATE).getInt("unreadCount", 0);
        ((TextView) findViewById(R.id.notifications_count)).setText(unreadCount > 0 ? Integer.toString(unreadCount) : "  ");

        addTileScreenPage("Notifications", NotificationsPage.class, new String[]{});
    }

}