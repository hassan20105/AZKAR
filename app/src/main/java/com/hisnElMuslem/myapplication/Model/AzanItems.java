package com.hisnElMuslem.myapplication.Model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("com.hisnElMuslem.myapplication.Model.AzanItems")
public class AzanItems {
    int timeImg;
    String prayName;
    int soundImg;
    String time;

    public AzanItems() {
    }

    public AzanItems(int timeImg, String prayName,  String time, int soundImg) {
        this.timeImg = timeImg;
        this.prayName = prayName;
        this.soundImg = soundImg;
        this.time = time;

    }

    public AzanItems(String prayName, String time) {
        this.prayName = prayName;
        this.time = time;
    }

    public int getTimeImg() {
        return timeImg;
    }

    public void setTimeImg(int timeImg) {
        this.timeImg = timeImg;
    }

    public String getPrayName() {
        return prayName;
    }

    public void setPrayName(String prayName) {
        this.prayName = prayName;
    }

    public int getSoundImg() {
        return soundImg;
    }

    public void setSoundImg(int soundImg) {
        this.soundImg = soundImg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
