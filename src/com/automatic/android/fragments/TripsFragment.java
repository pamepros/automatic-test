package com.automatic.android.fragments;

import java.util.ArrayList;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.actionbarsherlock.app.SherlockFragment;
import com.automatic.android.BaseApplication;
import com.automatic.android.R;
import com.automatic.android.adapter.TripsAdapter;
import com.automatic.android.callbacks.TripsCallback;
import com.automatic.android.model.Trip;

public class TripsFragment extends SherlockFragment{

	private View view;
	private TripsAdapter _adapter;
	private EditText filterEditText;
	private ProgressBar loading;
	private ListView list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		view = inflater.inflate(R.layout.fragment_trips, container, false);
		
		loading = (ProgressBar)view.findViewById(R.id.progressBar);
		loading.setVisibility(view.VISIBLE);
		
		_adapter = new TripsAdapter(
				this.getActivity().getApplicationContext(), 
				R.layout.adapter_trip_item, 
				new ArrayList<Trip>()
				);

		list = (ListView) view.findViewById(R.id.tripsList);
		list.setVisibility(view.GONE);
		list.setAdapter(_adapter);

        // set bar to left side -only on kitkat >
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			list.setVerticalScrollbarPosition(View.SCROLLBAR_POSITION_LEFT);
		}

		BaseApplication.getAPIController().getAllTrips(new TripsCallback() {

			@Override
			public void onSuccess(ArrayList<Trip> trips) {
				showData(trips);
			}

			@Override
			public void onError(String message) {
				Log.i("response error", message);
			}
		});

		filterEditText = (EditText) view.findViewById(R.id.filterEditText);
		filterEditText.addTextChangedListener(new SearchTextWatcher());
		return view;
	}
	
	private void showData(ArrayList<Trip> trips) {

		_adapter.clear();
		_adapter.sortByDate(trips);
		_adapter.addAll(trips);
		_adapter.notifyDataSetChanged();

        //remove preloader and show list
        loading.setVisibility(view.GONE);
        list.setVisibility(view.VISIBLE);
	}
	
	private class SearchTextWatcher implements TextWatcher{
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {						
		}
		
		@Override
		public void afterTextChanged(Editable s) {	
			_adapter.getFilter().filter(s.toString());
		}
	}
}
