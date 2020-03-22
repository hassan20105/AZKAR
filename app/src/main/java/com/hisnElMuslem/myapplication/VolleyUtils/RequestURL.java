package com.hisnElMuslem.myapplication.VolleyUtils;

import android.content.Context;
import android.os.WorkSource;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.hisnElMuslem.myapplication.Adapters.MyRecyclerViewAdapter;
import com.hisnElMuslem.myapplication.Model.AzanItems;
import com.hisnElMuslem.myapplication.R;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestURL {

    public  static Map askAPI (final RecyclerView listRecyclerView, Context context , String pathOfAPIs )
    {
        final List azanItemsList = new ArrayList<AzanItems>();
        final MyRecyclerViewAdapter[] recyclerViewAdapter = {new MyRecyclerViewAdapter(context, azanItemsList)};
        Map<String,String>prayer_times_values = new HashMap<>();

        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, pathOfAPIs, null,
                new Response.Listener< JSONObject >() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject prayerObject = response.getJSONObject("data");
                            Toast.makeText(context, ""+prayerObject.getJSONObject("timings").get("Asr"), Toast.LENGTH_SHORT).show();
                            azanItemsList.add(new AzanItems(R.drawable.cloudy_day,"Fajr",prayerObject.getJSONObject("timings").get("Fajr").toString(),R.drawable.sound));
                            azanItemsList.add(new AzanItems(R.drawable.sun,"Dhuhr",prayerObject.getJSONObject("timings").get("Dhuhr").toString(),R.drawable.sound));
                            azanItemsList.add(new AzanItems(R.drawable.cloud,"Asr",prayerObject.getJSONObject("timings").get("Asr").toString(),R.drawable.sound));
                            azanItemsList.add(new AzanItems(R.drawable.cloudy_day,"Maghrib",prayerObject.getJSONObject("timings").get("Maghrib").toString(),R.drawable.sound));
                            azanItemsList.add(new AzanItems(R.drawable.night,"Isha",prayerObject.getJSONObject("timings").get("Isha").toString(),R.drawable.sound));
                            prayer_times_values.put("Sunrise",prayerObject.getJSONObject("timings").get("Sunrise").toString());
                            prayer_times_values.put("Fajr",prayerObject.getJSONObject("timings").get("Fajr").toString());
                            prayer_times_values.put("Dhuhr",prayerObject.getJSONObject("timings").get("Dhuhr").toString());
                            prayer_times_values.put("Asr",prayerObject.getJSONObject("timings").get("Asr").toString());
                            prayer_times_values.put("Maghrib",prayerObject.getJSONObject("timings").get("Maghrib").toString());
                            prayer_times_values.put("Isha",prayerObject.getJSONObject("timings").get("Isha").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        recyclerViewAdapter[0] = new MyRecyclerViewAdapter(context, azanItemsList);
                        listRecyclerView.setAdapter(recyclerViewAdapter[0]);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);

        return prayer_times_values;
    }
}
