package com.automatic.android.interfaces;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class OnTripItemClickListener implements OnItemClickListener {

	public static Activity activity;
	
	public OnTripItemClickListener(Activity activity) {
		this.activity = activity;
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapter, View arg1, int position, long arg3) {
	}
}
