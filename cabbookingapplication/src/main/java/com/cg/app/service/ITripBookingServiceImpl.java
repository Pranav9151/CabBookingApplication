package com.cg.app.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Cab;
import com.cg.app.entities.Customer;
import com.cg.app.entities.TripBooking;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CabNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.TripBookingNotFoundException;
import com.cg.app.repository.ICustomerRepository;
import com.cg.app.repository.ITripBookingRepository;

@Service
public class ITripBookingServiceImpl implements ITripBookingService {


	@Autowired
	private ITripBookingRepository tripBookingRepo;
	
	@Autowired
	private ICustomerRepository customerRepo;
	
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		return tripBookingRepo.save(tripBooking);
	
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {

		Optional<TripBooking> opt= tripBookingRepo.findById(tripBooking.getTripBookingId());
		
		if(opt.isPresent()) {
			
			return tripBookingRepo.save(tripBooking);
		
		}
		else
			throw new TripBookingNotFoundException("TripBooking does not exist with the Id");
		
	}

	@Override
	public List<TripBooking> deleteTripBooking(int tripBookingId) {
         
		Optional<TripBooking> opt= tripBookingRepo.findById(tripBookingId);
		
		if(opt.isPresent()) {
			TripBooking tripBooking= opt.get();
			tripBookingRepo.delete(tripBooking);
			
			return tripBookingRepo.findAll();
			
		}
		else
			throw new TripBookingNotFoundException("TripBooking does not exist with the Id");
		
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		

		Optional<Customer> opt= customerRepo.findById(customerId);
		
		
		if(opt.isPresent()) {
			
			Customer customer= opt.get();
			
			return customer.getTripBookings();
			
		}
		else
			throw new CustomerNotFoundException("Customer does not exist..");
		
	}

//	@Override
//	public float calculateBill(int customerId) {
//	
//	Optional<Customer> opt= customerRepo.findById(customerId);
//		
//		if(opt.isPresent()) {
//			
//			Customer customer= opt.get();
//			return tripBooking.getCustomer().getCab();
//			
//		}else
//			throw new CustomerNotFoundException("Invalid Cab Id");
//	}

	@Override
	public List<TripBooking> viewAllTripsById(int tripbookingId) {
		

		Optional<TripBooking> opt= tripBookingRepo.findById(tripbookingId);
		
		
		if(opt.isPresent()) {
			
			TripBooking tripBooking= opt.get();
			
			return tripBooking.getCustomer().getTripBookings();
			
		}
		else
			throw new TripBookingNotFoundException("Trip does not exist..");
		
		
		
	}
	
	

}
