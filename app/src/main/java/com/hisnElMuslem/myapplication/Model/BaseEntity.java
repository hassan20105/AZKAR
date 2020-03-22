package com.hisnElMuslem.myapplication.Model;

import androidx.room.PrimaryKey;

public class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
