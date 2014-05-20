package com.automatic.android.activities;

import android.os.Bundle;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.automatic.android.R;
import com.automatic.android.fragments.TripsFragment;

public class MainActivity extends SherlockFragmentActivity {

	private TripsFragment tripsFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ActionBar actionBar = getSupportActionBar();

		// Show Actionbar Icon
		actionBar.setDisplayShowHomeEnabled(true);
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    if (savedInstanceState == null) {
	    	tripsFragment = new TripsFragment();
	    	getSupportFragmentManager().beginTransaction()
				.replace(R.id.trips_frame, tripsFragment)
				.addToBackStack(null)
				.commitAllowingStateLoss();
	    }else{
	    	tripsFragment = (TripsFragment) getSupportFragmentManager().findFragmentById(R.id.trips_fragment);
	    }
	}

}
