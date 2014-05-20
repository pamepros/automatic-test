package com.automatic.android.parser;

/**
* @copyright Urucas
* @license   Copyright (C) 2013. All rights reserved
* @version   Release: 1.0.0
* @link       http://urucas.com
* @developers Bruno Alassia, Pamela Prosperi
*/

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.automatic.android.model.Trip;

public abstract class TripsParser {

	public static ArrayList<Trip> parse(JSONArray responseArray) {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		for(int i=0;i <responseArray.length();i++){
			try {
				JSONObject object = responseArray.getJSONObject(i);
				Trip trip = TripParser.parse(object);
				if(trip != null) {
					trips.add(trip);
				}
			} catch (JSONException e) {
			}
		}
		return trips;
	}
}
