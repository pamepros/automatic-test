package com.automatic.android.model;

public class Location {

	private String name, display_name;
	private long lat, lon;
	private int accuracy_m;
	
	public Location(String name,String display_name,long lat,long lon,int accuracy_m) {
		this.name = name;
		this.display_name = display_name;
		this.lat = lat;
		this.lon = lon;
		this.accuracy_m = accuracy_m;
	}
	
	public String getName(){
		return this.name;
	}
	
	public long getLat() {
		return this.lat;
	}

	public long getLon() {
		return this.lon;
	}

	public int getAccuracy() {
		return this.accuracy_m;
	}
	
	public String getDisplayName() {
		return this.display_name;
	}
	
}
