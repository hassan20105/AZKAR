package com.hisnElMuslem.myapplication.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.io.Serializable;

@Entity(tableName = "ZekrItems")
public class ZekrItems extends BaseEntity implements Serializable {

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "zekr")
    private String zekr;

    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "count")
    private String count;
    @ColumnInfo(name = "reference")
    private String reference;
    public ZekrItems(){}
    public ZekrItems(String category, String zekr, String description, String count, String reference) {
        this.category = category;
        this.zekr = zekr;
        this.description = description;
        this.count = count;
        this.reference = reference;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getZekr() {
        return zekr;
    }

    public void setZekr(String zekr) {
        this.zekr = zekr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


}
