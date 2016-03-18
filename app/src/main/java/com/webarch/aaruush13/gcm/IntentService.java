package com.webarch.aaruush13.gcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Message;

import com.google.android.gcm.GCMBaseIntentService;
import com.webarch.aaruush13.Aaruush13;
import com.webarch.aaruush13.R;
import com.webarch.aaruush13.tiles.notifications.NotificationsPage;

public class IntentService extends GCMBaseIntentService {

    public IntentService() {
        super("295619338844");
    }

    @Override
    protected void onMessage(Context context, Intent intent) {
        String msg = intent.getExtras().getString("msg");
        if (msg.contains("testmsg")) {
            return;
        }
        msg = msg.replaceAll("\\^", "");
        msg = msg.replaceAll("\\|", "");

        Notification notification = new Notification(R.drawable.contact_icon, msg.split("~")[2], System.currentTimeMillis());
//        notification.setLatestEventInfo(context, "Aaruush'13", msg.split("~")[2], PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0));
        notification.defaults = Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS;
        if (((AudioManager) getSystemService(AUDIO_SERVICE)).shouldVibrate(AudioManager.VIBRATE_TYPE_RINGER)) {
            notification.defaults |= Notification.DEFAULT_VIBRATE;
        }
        notification.flags = Notification.FLAG_SHOW_LIGHTS;
        ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(0, notification);

        Aaruush13 aaruush13 = (Aaruush13) getApplication();
        SharedPreferences preferences = context.getSharedPreferences("Notifications", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (aaruush13.tileScreenActivity != null && aaruush13.tileScreenActivity.getTileScreenTitle().equals("Notifications") && aaruush13.tileScreenActivity.isInForeground()) {
            Message message = Message.obtain();
            message.obj = msg + "^";
            NotificationsPage notificationsPage = (NotificationsPage) aaruush13.tileScreenActivity.getTileScreenPage("Notifications");
            if (notificationsPage != null) {
                notificationsPage.getMsgHandler().sendMessage(message);
            }
        } else {
            int unreadCount = preferences.getInt("unreadCount", 0) + 1;
            if (aaruush13.mainActivity != null) {
//                ((NotificationsTile) aaruush13.mainActivity.findViewById(R.id.notifications_tile)).setNotificationsCount(unreadCount);
            }
            editor.putInt("unreadCount", unreadCount);
            msg += "^";
        }
        editor.putString("msgs", preferences.getString("msgs", "") + msg + "|");
        editor.commit();
    }

    @Override
    protected void onError(Context context, String errorId) {
    }

    @Override
    protected void onRegistered(Context context, String registrationId) {
    }

    @Override
    protected void onUnregistered(Context context, String registrationId) {
    }

}