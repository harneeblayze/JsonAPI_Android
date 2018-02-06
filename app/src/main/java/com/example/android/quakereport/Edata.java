package com.example.android.quakereport;

/**
 * Created by HARNY on 1/19/2018.
 */

public class Edata {
    private String location;
    private String magnitude;
   // private String date;
    private long mTimeInMillisecs;
    public Edata(String mag, String mLoc, long timeInMillisecs){
        location = mLoc;
        magnitude = mag;
        mTimeInMillisecs = timeInMillisecs;
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

    public String getMagnitude() {
        return magnitude;
    }
}
