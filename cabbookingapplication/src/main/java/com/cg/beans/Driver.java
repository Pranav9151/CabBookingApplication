package com.cg.beans;

public class Driver {
	
	private int driverId;
	private String licenseNo;
	private float rating;
	
	public Driver(int driverId, String licenseNo, float rating) {
		super();
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.rating = rating;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	
	
	
	
	

}
