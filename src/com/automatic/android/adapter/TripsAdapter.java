package com.automatic.android.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import com.automatic.android.BaseApplication;
import com.automatic.android.R;
import com.automatic.android.comparator.TripsComparator;
import com.automatic.android.model.Trip;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

public class TripsAdapter extends ArrayAdapter<Trip> {

	private ArrayList<Trip> _trips;

	public TripsAdapter(Context context, int resource, ArrayList<Trip> trips) {
		super(context, resource, trips);
		_trips = trips;
	}
	
	private static class ViewHolder{

		public TextView tripVehicle;
		public TextView tripFrom;
		public TextView tripTo;
		public TextView dateFrom;
		public TextView dateTo;
		public ImageView mapImage;
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
		LayoutInflater inflater = (LayoutInflater) this.getContext()
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = convertView;
		if(rowView == null) {
			rowView = inflater.inflate(R.layout.adapter_trip_item, parent, false);
			
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.tripVehicle = (TextView) rowView.findViewById(R.id.tripVehicleTxt);
			viewHolder.tripFrom = (TextView) rowView.findViewById(R.id.tripFromTxt);
			viewHolder.tripTo = (TextView) rowView.findViewById(R.id.tripToTxt);
			viewHolder.dateFrom = (TextView) rowView.findViewById(R.id.tripStartDateTxt);
			viewHolder.dateTo = (TextView) rowView.findViewById(R.id.tripEndDateTxt);
			viewHolder.mapImage = (ImageView) rowView.findViewById(R.id.mapImage);
			rowView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) rowView.getTag();
		
		Trip trip = getItem(position);
		
		if(trip.getVehicle() != null) {
			holder.tripVehicle.setText("Car: "+trip.getVehicle().getDisplayName() + " "+ String.valueOf(trip.getVehicle().getYear()));
		}
		holder.tripFrom.setText("From: "+trip.getStartLocation().getDisplayName());
		holder.tripTo.setText("To: "+trip.getEndLocation().getDisplayName());
		
		long start_date = trip.getStartDate().getTime();
		long end_date = trip.getEndDate().getTime();
		SimpleDateFormat month_date = new SimpleDateFormat("MMM-dd HH:mm");
		String start = month_date.format(start_date);
		String end = month_date.format(end_date);
		
		holder.dateFrom.setText(start);
		holder.dateTo.setText(end);
		
		//map
		String url = "http://maps.googleapis.com/maps/api/staticmap?size=350x250&path=weight:5%7Ccolor:0x2fc0df%7Cenc:"+trip.getPath();
		try {
			BaseApplication.getImageLoader().DisplayImage(url, holder.mapImage);
		}catch(Exception e){}
		
		return rowView;
	}
	
	public void addAll(ArrayList<Trip> trips) {
		for(int i=0; i<trips.size(); i++) {
			insert(trips.get(i), getCount());
		}
		_trips = sortByDate(trips);
	}
	
	@Override
	public Filter getFilter() {
		return new Filter() {
			private ArrayList<Trip> trips;

			@SuppressWarnings("unchecked")
	        @Override
	            protected void publishResults(CharSequence constraint, FilterResults results) {
					if(results != null && results.count > 0) {
						clear();
						for(int i=0; i<results.count; i++) {
							trips = (ArrayList<Trip>) results.values;
							trips = sortByDate(trips);
							insert(trips.get(i), getCount());
						}
						notifyDataSetChanged();                   
	                }
	                else {
	                    notifyDataSetInvalidated();	                    
	                }		 	
	            }

	            @Override
	            protected FilterResults performFiltering(CharSequence constraint) {
	            	ArrayList<Trip> filteredResults = getFilteredResults(constraint);
	                FilterResults results = new FilterResults();
	                results.values = filteredResults;
	                results.count  = filteredResults.size();
	                
	                return results;	                
	            }
	        };
	    }

	public ArrayList<Trip> getFilteredResults(CharSequence constraint) {
		if(constraint.length() == 0){
			return _trips;
		}
		ArrayList<Trip> result  = new ArrayList<Trip>();			
		String q = constraint.toString().toLowerCase();
		for(int i=0; i<_trips.size();i++) {
			Trip c = _trips.get(i);
			String startLocation = c.getStartLocation().getName().toLowerCase();
			String endLocation = c.getEndLocation().getName().toLowerCase();
			if(startLocation.contains(q) || endLocation.contains(q)){
				result.add(c);
			}
		}	
		
		return result;	
	}	
	
	public ArrayList<Trip> sortByDate(ArrayList<Trip> _c) {
		TripsComparator c = new TripsComparator();
		Collections.sort(_c, c);
		return _c;
	}

	public void reset() {
		clear();
		addAll(_trips);
		notifyDataSetChanged();
	}
}
