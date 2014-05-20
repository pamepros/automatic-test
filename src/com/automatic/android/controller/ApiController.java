package com.automatic.android.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.util.Log;

import com.automatic.android.BaseApplication;
import com.automatic.android.R;
import com.automatic.android.callbacks.TripsCallback;
import com.automatic.android.model.Trip;
import com.automatic.android.parser.TripParser;
import com.automatic.android.parser.TripsParser;
import com.urucas.services.JSONRequestTask;
import com.urucas.services.JSONRequestTaskHandler;
import com.urucas.services.RequestTask;
import com.urucas.services.RequestTaskHandler;
import com.urucas.utils.Utils;

public class ApiController {

	private static String BASE_URL = "http://cleeck.urucas.com.ar/automatic/response.json";
	
	public void getAllTrips(final TripsCallback callback) {
	
		if(!isConnected()) {
			Utils.Toast(BaseApplication.getInstance(), R.string.no_connection);
			return;
		}
		
		//String url = BASE_URL + "/trips";
		String url = "http://cleeck.urucas.com.ar/automatic/response.json";
		try {
			new JSONRequestTask(new JSONRequestTaskHandler() {

				@Override
				public void onSuccess(JSONObject result) {
				}

				@Override
				public void onError(String message) {
					callback.onError(message);
				}

				@Override
				public void onSuccess(JSONArray result) {
					Log.i("response array",result.toString());
					try {
						// parse json from trip
						Log.i("response",result.toString());
						ArrayList<Trip> trips = TripsParser.parse(result);
						//Trip event = TripParser.parse(result);
						callback.onSuccess(trips);
						
					} catch (Exception e) {
						e.printStackTrace();
						callback.onError("error parsing");
					}
				}

			}).addHeader("Authorization", "token 8eb376dbda0243633269fd8c3e6dd820aa684646").execute(BASE_URL);
			
		} catch (Exception e) {
			callback.onError("error calling api");
		}
	}
	
	private boolean isConnected() {
		return Utils.isConnected(BaseApplication.getInstance().getApplicationContext());
	}

	

}
