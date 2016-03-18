package com.webarch.aaruush13.tiles.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.webarch.aaruush13.components.TileScreenPage;

public class NotificationsPage extends TileScreenPage {

    private SharedPreferences preferences;
    private Handler msgHandler;
    private LinearLayout notificationsLayout;
    private String lastDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getActivity().getSharedPreferences(getTileScreenPageTitle(), Context.MODE_PRIVATE);
        msgHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                addMsg((String) msg.obj);
            }

        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScrollView scrollView = new ScrollView(getActivity());
        scrollView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        scrollView.setFillViewport(true);

        notificationsLayout = new LinearLayout(getActivity());
        notificationsLayout.setOrientation(LinearLayout.VERTICAL);
        notificationsLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        scrollView.addView(notificationsLayout, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        return scrollView;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        String msgsString = preferences.getString("msgs", "");
//        if (!msgsString.isEmpty()) {
//            String[] msgs = msgsString.split("\\|");
//            lastDate = null;
//            for (String msg : msgs) {
//                addMsg(msg);
//            }
//
//            tile.setNotificationsCount(0);
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putInt("unreadCount", 0);
//            editor.putString("msgs", preferences.getString("msgs", "").replaceAll("\\^", "")).commit();
//            editor.commit();
//        }
//    }

    private void addMsg(String msg) {
        String[] msgParts = msg.split("~");
        if (!msgParts[0].equals(lastDate)) {
            lastDate = msgParts[0];
            TextView textView = new TextView(getActivity());
            textView.setPadding(0, aaruush13.border3, 0, aaruush13.border3);
            textView.setText(msgParts[0]);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text3);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextColor(Color.BLACK);
            notificationsLayout.addView(textView, 0, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        }
        final TextView textView = new TextView(getActivity());
        if (msg.endsWith("^")) {
            msgParts[2] = msgParts[2].substring(0, msgParts[2].length() - 1);
//            ValueAnimator colorFadeOutAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), tileScreenActivity.getColor2(), Color.WHITE);
//            colorFadeOutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    textView.setBackgroundColor((Integer) animation.getAnimatedValue());
//                }
//
//            });
//            colorFadeOutAnimator.setDuration(3000);
//            colorFadeOutAnimator.start();
        }
        textView.setPadding(0, aaruush13.border3, 0, aaruush13.border3);
        textView.setText(msgParts[1] + " " + msgParts[2]);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, aaruush13.text3);
        textView.setTextColor(Color.BLACK);
        notificationsLayout.addView(textView, 1, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
    }

    public Handler getMsgHandler() {
        return msgHandler;
    }

}