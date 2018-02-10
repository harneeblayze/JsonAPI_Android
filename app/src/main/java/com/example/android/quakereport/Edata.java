package com.example.android.quakereport;

/**
 * Created by HARNY on 1/19/2018.
 */

public class Edata {
    private String location;
    private double magnitude;
   // private String date;
    private long mTimeInMillisecs;
    private  String mUrl;
    public Edata(double mag, String mLoc, long timeInMillisecs, String url){
        location = mLoc;
        magnitude = mag;
        mTimeInMillisecs = timeInMillisecs;
        mUrl = url;
    }

    public String getLocation() {
        return location;
    }

    //public String getDate() {
      //  return date;
    //}


    public long getmTimeInMillisecs() {
        return mTimeInMillisecs;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getmUrl() {
        return mUrl;
    }
}
