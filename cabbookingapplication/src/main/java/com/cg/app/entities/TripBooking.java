package com.cg.app.entities;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class TripBooking {
	
	private int tripBookingId;
	private Customer customer;
	private Driver driver;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
	
public TripBooking() {
	// TODO Auto-generated constructor stub
}
	


	public TripBooking(int tripbookingId, Customer customer, Driver driver, String fromLocation, String toLocation,
			LocalDateTime fromDateTime, LocalDateTime toDateTime, boolean status, float distanceInKm, float bill) {
		super();
		this.tripBookingId = tripBookingId;
		this.customer = customer;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
		
		
		
	}


	public int getTripBookingId() {
		return tripBookingId;
	}


	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	public String getFromLocation() {
		return fromLocation;
	}


	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}


	public String getToLocation() {
		return toLocation;
	}


	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}


	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}


	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}


	public LocalDateTime getToDateTime() {
		return toDateTime;
	}


	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public float getDistanceInKm() {
		return distanceInKm;
	}


	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}


	public float getBill() {
		return bill;
	}


	public void setBill(float bill) {
		this.bill = bill;
	}
	
	

	@Override
	public String toString() {
		return "TripBooking [tripbookingId=" + tripBookingId + ", customer=" + customer + ", driver=" + driver
				+ ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime
				+ ", toDateTime=" + toDateTime + ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill="
				+ bill + "]";
	}
	
	
	
	
	
	

}
