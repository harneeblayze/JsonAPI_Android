package com.example.android.quakereport;

/**
 * Created by HARNY on 1/19/2018.
 */

public class Edata {
    private String location;
    private String magnitude;
    private String date;
    public Edata(String mag, String mLoc, String mdate){
        location = mLoc;
        magnitude = mag;
        date = mdate;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getMagnitude() {
        return magnitude;
    }
}
