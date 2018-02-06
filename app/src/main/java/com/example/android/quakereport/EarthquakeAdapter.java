package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by HARNY on 1/19/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Edata> {

    public EarthquakeAdapter(Activity context, ArrayList<Edata>earthquakes){

        super(context,0,earthquakes);
    }

    //we need this string to use as our separator to split one string data into two results
    private static final String LOCATION_SEPARATOR = "of";

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        //we will need the following variable declarations bellow for storing the locations we want to split and we declare here due to scope of use.
        String offsetLocation;
        String primaryLoc;
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;

        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.each_item,parent, false);
        }
        // Find the earthquake at the given position in the list of earthquakes
        Edata currentData = getItem(position);
        // Find the TextView with view ID magnitude
        TextView magnit = (TextView)listItemView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in that TextView
        magnit.setText(currentData.getMagnitude());

        //we first get the location from the json through our adapter through our custom class and store it as the original location
        String originalLocation = currentData.getLocation();
        //the splitting happens here, we want to check for 2 conditions
        //1) if the original location contains the word "of".. now if it does we want to split the string using that word "of" as separator
        // then save it in a new string array called parts
        //then the offset variable above, we will use it to save the first part[0] before the "of" and we shall include the string "of"
        //while in the second variable called primaryLoc we save just the part after the "of" which is part[1]
        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String parts[] = originalLocation.split(LOCATION_SEPARATOR);
            offsetLocation = parts[0] + LOCATION_SEPARATOR;
            primaryLoc = parts[1];
        }else {
            //else we save in the variable offset with the string near-the. we do this by first getting context and then getString
            offsetLocation = getContext().getString(R.string.near_the);
            primaryLoc = originalLocation;
        }

        TextView offset = (TextView)listItemView.findViewById(R.id.offset_loc);
        offset.setText(offsetLocation);


        // Find the TextView with view ID location
        TextView locate = (TextView)listItemView.findViewById(R.id.loc);
        // Display the location of the current earthquake in that TextView
        locate.setText(primaryLoc);
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentData.getmTimeInMillisecs());
        // Find the TextView with view ID date
        TextView dateView = (TextView)listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formatted = dateFormatter(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formatted);

        // Find the TextView with view ID time
        TextView timeView = (TextView)listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = timeFormatter(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);
        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */

    private String dateFormatter(Date x){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        String result = dateFormat.format(x);
        return result;
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */

    private  String timeFormatter(Date x){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String timeformatted = timeFormat.format(x);
        return timeformatted;
    }
}
