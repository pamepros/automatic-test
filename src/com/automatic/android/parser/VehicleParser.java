package com.automatic.android.parser;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.automatic.android.model.Vehicle;

public abstract class VehicleParser {

	public static Vehicle parse(JSONObject result) {
		
		try {
			String uri = result.getString("uri");
			String id = result.getString("id");
			int year = result.getInt("year");
			String make = result.getString("make");
			String model = result.getString("model");
			String display_name = result.getString("display_name");
			String color = result.getString("color");
			
			Vehicle vehicle = new Vehicle(id, uri, year, make, model, display_name, color);
			
			return vehicle;
			
		} catch (JSONException e) { e.printStackTrace(); }
		
		return null;
	}
	
}
