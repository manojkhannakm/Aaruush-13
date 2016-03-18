package com.webarch.aaruush13.gcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

public class CloudMessaging {

    private Context context;
    private SharedPreferences preferences;
    private AsyncTask<Object, Void, Void> connectAsyncTask;

    public CloudMessaging(final Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("CloudMessaging", Context.MODE_PRIVATE);
        if (isAppUpdated() || isRegExpired()) {
            connectAsyncTask = new AsyncTask<Object, Void, Void>() {

                @Override
                protected Void doInBackground(Object... params) {
                    GoogleCloudMessaging googleCloudMessaging = GoogleCloudMessaging.getInstance(context);
                    String oldRegId = preferences.getString("regId", ""), newRegId = null;
                    while (connectAsyncTask != null) {
                        try {
                            if (newRegId == null) {
                                newRegId = googleCloudMessaging.register("295619338844");
                                if (oldRegId.equals(newRegId)) {
                                    connectAsyncTask = null;
                                    break;
                                }
                            }
//                            HttpPost httpPost = new HttpPost("http://itdatacenter.x10.mx/aaruush13/submit_reg_id.php");
//                            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                            nameValuePairs.add(new BasicNameValuePair("oldRegId", oldRegId));
//                            nameValuePairs.add(new BasicNameValuePair("newRegId", newRegId));
//                            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                            new DefaultHttpClient().execute(httpPost);
                            connectAsyncTask = null;
                        } catch (IOException e) {
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException ignored) {
                            }
                        }
                    }
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("regId", newRegId);
                    try {
                        editor.putFloat("regAppVer", Float.parseFloat(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName));
                    } catch (PackageManager.NameNotFoundException ignored) {
                    }
                    editor.putLong("regExpTime", System.currentTimeMillis() + 604800000);
                    editor.commit();
                    return null;
                }

            };
            connectAsyncTask.execute();
        }

    }

    public void onDestroy() {
        if (connectAsyncTask != null) {
            connectAsyncTask.cancel(true);
            connectAsyncTask = null;
        }
    }

    private boolean isAppUpdated() {
        try {
            return preferences.getFloat("regAppVer", -1.0f) < Float.parseFloat(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return true;
    }

    private boolean isRegExpired() {
        return preferences.getLong("regExpTime", -1) < System.currentTimeMillis();
    }

}