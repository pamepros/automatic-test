package com.automatic.android.parser;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.automatic.android.model.Location;
import com.automatic.android.model.Vehicle;

public abstract class LocationParser {

	public static Location parse(JSONObject result) {
		
		try {
			String name = result.getString("name");
			String display_name = result.getString("display_name");
			long lat = result.getLong("lat");
			long lon = result.getLong("lon");
			int accuracy_m = result.getInt("accuracy_m");
			
			Location location = new Location(name, display_name, lon, lat, accuracy_m);
			
			return location;
			
		} catch (JSONException e) { e.printStackTrace(); }
		
		return null;
	}
	
}
