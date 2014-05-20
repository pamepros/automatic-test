package com.automatic.android.parser;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.automatic.android.model.Location;
import com.automatic.android.model.Trip;
import com.automatic.android.model.Vehicle;

public abstract class TripParser {

	public static Trip parse(JSONObject result) {
		
		try {
			String uri = result.getString("uri");
			String id = result.getString("id");
			long start_time = result.getLong("start_time");
			long end_time = result.getLong("end_time");
			String start_time_zone = result.getString("start_time_zone");
			String end_time_zone = result.getString("end_time_zone");
			double distance_m = result.getDouble("distance_m");
			String fuel_cost_usd = result.getString("fuel_cost_usd");
			String fuel_volume_gal = result.getString("fuel_volume_gal");
			String average_mpg = result.getString("average_mpg");
			String path = result.getString("path");
			
			Trip trip = new Trip(id, uri, start_time, end_time, distance_m, path);
			
			Vehicle vehicle = VehicleParser.parse(result.getJSONObject("vehicle"));
			trip.setVehicle(vehicle);
			
			Location start = LocationParser.parse(result.getJSONObject("start_location"));
			trip.setStartLocation(start);
			
			Location end = LocationParser.parse(result.getJSONObject("end_location"));
			trip.setEndLocation(end);
			
			return trip;
			
		} catch (JSONException e) { e.printStackTrace(); }
		
		return null;
	}
	
}
