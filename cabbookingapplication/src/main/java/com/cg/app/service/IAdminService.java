package com.cg.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.app.entities.TripBooking;
import com.cg.app.exception.CustomerNotFoundException;

public interface IAdminService {
	
	public List<TripBooking>getAllTrips(int CustomerId) throws CustomerNotFoundException;
	public List<TripBooking>getTripsCabwise();
	public List<TripBooking>getTripsCustomerwise();
	public List<TripBooking>getTripsDatewise();
	
	public List<TripBooking>getAllTripsforDays(int customerId,LocalDateTime fromDate,LocalDateTime toDate)throws CustomerNotFoundException;
	
	

}
