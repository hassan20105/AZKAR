package com.hisnElMuslem.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hisnElMuslem.myapplication.R;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
    }

    public void onClickAzan(View view) {
        if(view.getId()==R.id.azan_imageView||view.getId()==R.id.azan_textView)
        startActivity(new Intent(this,AzanActivity.class));
        else if(view.getId()==R.id.azkar_imageView||view.getId()==R.id.azkar_textView)
        startActivity(new Intent(this, AzkarActivity.class));
    }
}
