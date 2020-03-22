package com.hisnElMuslem.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hisnElMuslem.myapplication.Model.AzanItems;
import com.hisnElMuslem.myapplication.R;
import com.hisnElMuslem.myapplication.XMLConverter.AzanItemsConverterToXML;


import java.io.IOException;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    Context context;
    private List<AzanItems> mData;
    private LayoutInflater mInflater;

    public MyRecyclerViewAdapter(Context context, List<AzanItems> mData) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.azanitems_layout, parent, false);
        try {
            AzanItemsConverterToXML.isSaveUpdate(mData,context.getFilesDir()+"/index.xml");
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AzanItems azanItems = mData.get(position);
        holder.pray_name.setText(azanItems.getPrayName());
        holder.timeTV.setText(azanItems.getTime());
        holder.img_time.setImageResource(azanItems.getTimeImg());
        holder.sound_Img.setImageResource(azanItems.getSoundImg());


        holder.sound_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (azanItems.getSoundImg() == R.drawable.sound) {
                    azanItems.setSoundImg(R.drawable.mute);
                    holder.sound_Img.setImageResource(azanItems.getSoundImg());
                } else{
                    azanItems.setSoundImg(R.drawable.sound);
                    holder.sound_Img.setImageResource(azanItems.getSoundImg());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_time, sound_Img;
        TextView afterTXT, timeDownTXT, pray_name, timeTV;

        public ViewHolder(final View itemView) {
            super(itemView);
            img_time = itemView.findViewById(R.id.img_time);
            sound_Img = itemView.findViewById(R.id.sound_Img);
            afterTXT = itemView.findViewById(R.id.afterTXT);
            timeDownTXT = itemView.findViewById(R.id.timeDownTXT);
            pray_name = itemView.findViewById(R.id.pray_name);
            timeTV = itemView.findViewById(R.id.timeTV);

        }
    }
}
