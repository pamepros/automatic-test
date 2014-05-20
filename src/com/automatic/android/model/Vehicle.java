package com.automatic.android.model;

public class Vehicle {

	private String id, uri, make, model, display_name, color;
	private int year;
	
	public Vehicle(String id,String uri,int year,String make,String model, String display_name, String color) {
		this.id = id;
		this.uri = uri;
		this.year = year;
		this.make = make;
		this.model = model;
		this.display_name = display_name;
		this.color = color;
	}
	
	public Vehicle(String id) {
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getUri() {
		return this.uri;
	}

	public int getYear() {
		return this.year;
	}

	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	public String getDisplayName() {
		return this.display_name;
	}
	
	public String getColor() {
		return color;
	}

}
