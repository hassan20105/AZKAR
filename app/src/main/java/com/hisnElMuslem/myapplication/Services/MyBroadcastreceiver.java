package com.hisnElMuslem.myapplication.Services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Calendar;

public class MyBroadcastreceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent x) {
        if ("android.intent.action.BOOT_COMPLETED".equals(x.getAction())) {
            Intent myIntent = new Intent(context, AlarmService.class);
            context.startService(myIntent);
            Toast.makeText(context, "wowaa", Toast.LENGTH_SHORT).show();

        }
    }
}
