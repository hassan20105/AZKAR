package com.hisnElMuslem.myapplication.Data.Factory;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hisnElMuslem.myapplication.Data.ZekrDao;
import com.hisnElMuslem.myapplication.Model.ZekrItems;

@Database(entities = {ZekrItems.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ZekrDao zekrDao();

}