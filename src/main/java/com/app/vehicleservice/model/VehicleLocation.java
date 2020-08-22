package com.app.vehicleservice.model;

import lombok.Data;

@Data
public class VehicleLocation {

	private double lat;
	private double lng;
	private String at;
	//In Angles
	private String bearingLocation;
}
