package com.hisnElMuslem.myapplication.Activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hisnElMuslem.myapplication.Adapters.AzkarRecycleViewAdapter;
import com.hisnElMuslem.myapplication.Model.ZekrItems;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;
import com.hisnElMuslem.myapplication.Utilities.CSVFile;

import java.io.InputStream;
import java.util.List;

public class AzkarActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private AzkarDBServices azkarDBServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_azkar);
        recyclerView = findViewById(R.id.rec_azkar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       azkarDBServices = new AzkarDBServices(this);
        if(azkarDBServices.selectZekrDetail().isEmpty())
        {
            requestCSVFile();
        }
        AzkarRecycleViewAdapter recyclerViewAdapter = new AzkarRecycleViewAdapter(this, azkarDBServices.selectCategoryDetail());
        recyclerView.setAdapter(recyclerViewAdapter);

    }



public void requestCSVFile(){
    InputStream inputStream = getResources().openRawResource(R.raw.sql);
    CSVFile csvFile = new CSVFile(inputStream);
    List <ZekrItems>zekrItems = csvFile.read();
    for(int i=0;i<zekrItems.size();i++)
    {
        azkarDBServices.insertZekr(zekrItems.get(i));
    }
}


   }
