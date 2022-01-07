package com.cg.app.entities;

public class TripBooking {
	private int tripbookingid;
	private String fromlocation;
	private String tolocation;
	private boolean status;
	private float distanceinkm;
	private float bill;
	public void TripBooking() {
	
	}
	public int getTripbookingid() {
		return tripbookingid;
	}
	public void setTripbookingid(int tripbookingid) {
		this.tripbookingid = tripbookingid;
	}
	public String getFromlocation() {
		return fromlocation;
	}
	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}
	public String getTolocation() {
		return tolocation;
	}
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getDistanceinkm() {
		return distanceinkm;
	}
	public void setDistanceinkm(float distanceinkm) {
		this.distanceinkm = distanceinkm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "TripBooking [tripbookingid=" + tripbookingid + ", fromlocation=" + fromlocation + ", tolocation="
				+ tolocation + ", status=" + status + ", distanceinkm=" + distanceinkm + ", bill=" + bill + "]";
	}
	public TripBooking(int tripbookingid, String fromlocation, String tolocation, boolean status, float distanceinkm,
			float bill) {
		super();
		this.tripbookingid = tripbookingid;
		this.fromlocation = fromlocation;
		this.tolocation = tolocation;
		this.status = status;
		this.distanceinkm = distanceinkm;
		this.bill = bill;
	}
	
	

}
