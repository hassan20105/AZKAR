package com.hisnElMuslem.myapplication.Activities;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.AlarmService;

import com.hisnElMuslem.myapplication.VolleyUtils.RequestURL;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AzanActivity extends AppCompatActivity {


    private String pathOfAPIs;
    Location location;
    List<Address> addresses;
    Geocoder geocoder;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_azan);
        recyclerView = findViewById(R.id.recycle_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        pathOfAPIs = "https://api.aladhan.com/timingsByAddress/"+formatter.format(new Date())+"?address=Cairo,Egypt&method=8&tune=2,3,4,5,2,3,4,5,-3";
        if (ContextCompat.checkSelfPermission(AzanActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(AzanActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(AzanActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }else{
                ActivityCompat.requestPermissions(AzanActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
        else
        {
          RequestURL.askAPI(recyclerView,this,pathOfAPIs);
            startAlarmService();
        }
        LocationManager locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        geocoder = new Geocoder(this);


}



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults){
        switch (requestCode){
            case 1: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(AzanActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                        RequestURL.askAPI(recyclerView,this,pathOfAPIs);
                        startAlarmService();
                    }

                    
                    
                }else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    public void startAlarmService(){
        Intent intent = new Intent(this,AlarmService.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent =  PendingIntent.getService(this,0,intent,0);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,2);
        calendar.set(Calendar.MINUTE,54);
        calendar.set(Calendar.SECOND,2);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),24*60*60*1000,pendingIntent);

    }


}
