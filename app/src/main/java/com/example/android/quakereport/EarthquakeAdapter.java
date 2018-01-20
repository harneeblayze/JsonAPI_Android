package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HARNY on 1/19/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Edata> {

    public EarthquakeAdapter(Activity context, ArrayList<Edata>earthquakes){

        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.each_item,parent, false);
        }

        Edata currentData = getItem(position);

        TextView magnit = (TextView)listItemView.findViewById(R.id.magnitude);
        magnit.setText(currentData.getMagnitude());

        TextView locate = (TextView)listItemView.findViewById(R.id.loc);
        locate.setText(currentData.getLocation());

        TextView time = (TextView)listItemView.findViewById(R.id.date);
        time.setText(currentData.getDate());

        return listItemView;
    }
}
