package com.cg.app.service;

import java.util.List;

import com.cg.app.entities.TripBooking;

public interface ITripBookingService {
	
	public TripBooking insertTripBooking(TripBooking tripBooking);

	public TripBooking updateTripBooking(TripBooking tripBooking);

	public List<TripBooking> deleteTripBooking(int tripBookingId);

	public List<TripBooking> viewAllTripsCustomer(int customerId);

	//public float calculateBill(int customerId);

	public List<TripBooking> viewAllTripsById(int tripbookingId);

}
