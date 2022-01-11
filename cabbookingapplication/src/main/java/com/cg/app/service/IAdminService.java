package com.cg.app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.app.entities.Admin;
import com.cg.app.entities.TripBooking;
import com.cg.app.exception.CustomerNotFoundException;

public interface IAdminService {
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public List<Admin> deleteAdmin(int adminId);
	
	public List<TripBooking>getAllTrips(int CustomerId) throws CustomerNotFoundException;
	public List<TripBooking>getTripsCabwise(Integer cabId);
	public List<TripBooking>getTripsCustomerwise(Integer customerId);
	public List<TripBooking>getTripsDatewise();
	
	public List<TripBooking>getAllTripsforDays(int customerId,LocalDateTime fromDate,LocalDateTime toDate)throws CustomerNotFoundException;
	public Admin getAdminById(int adminId);
	
	

}
