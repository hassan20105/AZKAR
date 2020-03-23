package com.hisnElMuslem.myapplication.Activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hisnElMuslem.myapplication.Fragments.DynamicFragment;
import com.hisnElMuslem.myapplication.R;

public class AzkarDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_azkar_details);
        addFragement();
    }

    private void addFragement()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_left_in,R.anim.slide_left_out,R.anim.slide_right_in,R.anim.slide_right_out);
        DynamicFragment dynamicFragment = new DynamicFragment();
        fragmentTransaction.add(R.id.dynamicFrame,dynamicFragment);
        fragmentTransaction.commit();


    }
}
