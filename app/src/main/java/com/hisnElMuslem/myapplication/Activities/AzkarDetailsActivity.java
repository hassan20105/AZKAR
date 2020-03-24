package com.hisnElMuslem.myapplication.Activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.hisnElMuslem.myapplication.Fragments.DynamicFragment;
import com.hisnElMuslem.myapplication.Fragments.FragmentCollectionAdapter;
import com.hisnElMuslem.myapplication.Model.ZekrItems;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;

import java.util.ArrayList;
import java.util.List;

public class AzkarDetailsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentCollectionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_azkar_details);
        AzkarDBServices azkarDBServices = new AzkarDBServices(this);
        ArrayList<String> zekrItems = getIntent().getStringArrayListExtra("azkarList");
        viewPager = findViewById(R.id.view_pager);
        adapter = new FragmentCollectionAdapter(getSupportFragmentManager(), zekrItems);
        viewPager.setAdapter(adapter);


    }

   /* private void addFragement()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_left_in,R.anim.slide_left_out,R.anim.slide_right_in,R.anim.slide_right_out);
       overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_in);
        DynamicFragment dynamicFragment = new DynamicFragment();
        fragmentTransaction.replace(R.id.dynamicFrame,dynamicFragment);
        fragmentTransaction.commit();


    }*/
}
