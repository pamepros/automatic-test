package com.automatic.android.comparator;

import java.util.Comparator;

import com.automatic.android.model.Trip;


public class TripsComparator implements Comparator<Trip> {
	
	public int compare(Trip left, Trip right) {
        return Long.compare(right.getStartTime(), left.getEndTime());  
	}
}
