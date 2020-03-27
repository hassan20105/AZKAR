package com.hisnElMuslem.myapplication.Activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.hisnElMuslem.myapplication.Fragments.FragmentCollectionAdapter;
import com.hisnElMuslem.myapplication.R;

import java.util.ArrayList;

public class AzkarDetailsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentCollectionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_azkar_details);
        ArrayList<String> zekrItems = getIntent().getStringArrayListExtra("azkarList");
        viewPager = findViewById(R.id.view_pager);
        adapter = new FragmentCollectionAdapter(getSupportFragmentManager(), zekrItems);
        viewPager.setAdapter(adapter);


    }

}
