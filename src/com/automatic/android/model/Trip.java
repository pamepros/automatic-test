package com.automatic.android.model;

import java.util.Date;

public class Trip {

	private String id, uri, path;
	private long start_time, end_time;
	private double distance_m;
	private Vehicle vehicle;
	private Location start_loc, end_loc;
	
	public Trip(String id,String uri,long start_time,long end_time,double distance_m, String path) {
		this.id = id;
		this.uri = uri;
		this.start_time = start_time;
		this.end_time = end_time;
		this.distance_m = distance_m;
		this.path = path;
	}
	
	public Trip(String id) {
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getUri() {
		return this.uri;
	}

	public long getStartTime() {
		return this.start_time;
	}

	public long getEndTime() {
		return this.end_time;
	}
	
	public String getPath(){
		return this.path;
	};
	
	public Date getStartDate() {
		Date date = new Date(this.start_time);
		//DateFormat format = new SimpleDateFormat("MM-dd-yyyy h:mm:ss a");
		return date;
	}
	public Date getEndDate() {
		Date date = new Date(this.end_time);
		return date;
	}
	
	public double getDistance() {
		return distance_m;
	}
	
	public void setVehicle(Vehicle v){
		this.vehicle = v;
	}
	
	public Vehicle getVehicle(){
		return this.vehicle;
	}
	
	public void setStartLocation(Location start){
		this.start_loc = start;
	}
	
	public Location getStartLocation(){
		return start_loc;
	}
	
	public void setEndLocation(Location end){
		this.end_loc = end;
	}
	
	public Location getEndLocation(){
		return end_loc;
	}
}
