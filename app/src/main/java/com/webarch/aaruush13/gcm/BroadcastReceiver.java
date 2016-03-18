package com.webarch.aaruush13.gcm;

import android.content.Context;

import com.google.android.gcm.GCMBroadcastReceiver;

public class BroadcastReceiver extends GCMBroadcastReceiver {

    @Override
    protected String getGCMIntentServiceClassName(Context context) {
        return IntentService.class.getName();
    }

}