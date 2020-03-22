package com.hisnElMuslem.myapplication.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.hisnElMuslem.myapplication.Model.ZekrItems;

import java.util.List;

@Dao
public interface ZekrDao {
    @Insert
    long insertZekr(ZekrItems zekrItems);
    @Update
    int updateZekr(ZekrItems zekrItems);
    @Query("DELETE  FROM ZekrItems")
    int deleteAllZekr();
    @Query("SELECT * FROM ZekrItems where Category= (:input)")
    List<ZekrItems> selectZekrDetail(String input);
    @Query("SELECT * FROM ZekrItems")
    List<ZekrItems> selectZekrDetail();
    @Query("SELECT Distinct Category FROM ZekrItems")
    List<String> selectCategoryDetail();



}
