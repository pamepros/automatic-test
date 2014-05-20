package com.automatic.android.callbacks;

import java.util.ArrayList;

import com.automatic.android.model.Trip;

public interface TripsCallback {

	public void onSuccess(ArrayList<Trip> trips);
	public void onError(String message);
}
