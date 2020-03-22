package com.hisnElMuslem.myapplication.Services;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Calendar;


public class AlarmService extends Service {



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),notification);
        ringtone.play();
        Toast.makeText(this, "Service is running", Toast.LENGTH_SHORT).show();
        return Service.START_NOT_STICKY;
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public boolean onUnbind(Intent intent) {

        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
