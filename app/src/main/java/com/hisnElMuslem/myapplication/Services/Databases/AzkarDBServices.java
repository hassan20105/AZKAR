package com.hisnElMuslem.myapplication.Services.Databases;

import android.content.Context;

import androidx.room.Room;

import com.hisnElMuslem.myapplication.Data.Factory.AppDatabase;
import com.hisnElMuslem.myapplication.Data.ZekrDao;
import com.hisnElMuslem.myapplication.Model.ZekrItems;

import java.util.List;

public class AzkarDBServices implements ZekrDao {

    private AppDatabase db;
    public AzkarDBServices(Context context){
        db = Room.databaseBuilder(context,
                AppDatabase.class, "zekrDatabase").allowMainThreadQueries().build();
    }

    @Override
    public long insertZekr(ZekrItems zekrItems) {
        return db.zekrDao().insertZekr(zekrItems);
    }

    @Override
    public int updateZekr(ZekrItems zekrItems) {
        return db.zekrDao().updateZekr(zekrItems);
    }

    @Override
    public int deleteAllZekr() {
        return db.zekrDao().deleteAllZekr();
    }

    @Override
    public List<ZekrItems> selectZekrDetail(String input) {
        return db.zekrDao().selectZekrDetail(input);
    }

    @Override
    public List<ZekrItems> selectZekrDetail() {
        return db.zekrDao().selectZekrDetail();
    }

    @Override
    public List<String> selectCategoryDetail() {
        return db.zekrDao().selectCategoryDetail();
    }
}
