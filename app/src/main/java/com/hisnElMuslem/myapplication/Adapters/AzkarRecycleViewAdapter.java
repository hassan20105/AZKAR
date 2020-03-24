package com.hisnElMuslem.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.hisnElMuslem.myapplication.Activities.AzkarDetailsActivity;
import com.hisnElMuslem.myapplication.Data.Factory.AppDatabase;
import com.hisnElMuslem.myapplication.Data.ZekrDao;
import com.hisnElMuslem.myapplication.Model.AzanItems;
import com.hisnElMuslem.myapplication.Model.ZekrItems;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.Services.Databases.AzkarDBServices;

import java.util.ArrayList;
import java.util.List;

public class AzkarRecycleViewAdapter extends RecyclerView.Adapter<AzkarRecycleViewAdapter.ViewHolder>{
    Context context;
    private List<String> mData;
    private LayoutInflater mInflater;
    private AzkarDBServices azkarDBServices;
    public AzkarRecycleViewAdapter(Context context, List<String> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
        this.context = context;
        azkarDBServices = new AzkarDBServices(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.azkaritems_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String category = mData.get(position);
        holder.categoryTV.setText(category);
        holder.categoryTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AzkarDetailsActivity.class);
                intent.putExtra("azkarList", (ArrayList) azkarDBServices.selectZekrOnly(category));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTV = itemView.findViewById(R.id.categoryTV);
        }
    }


}
