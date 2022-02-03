package com.cg.app.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Cab;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Driver;
import com.cg.app.entities.TripBooking;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CabNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.repository.IAdminRepository;
import com.cg.app.repository.ICabRepository;
import com.cg.app.repository.ICustomerRepository;
import com.cg.app.repository.ITripBookingRepository;

@Service
public class IAdminServiceImpl  implements IAdminService{
	@Autowired
	private IAdminRepository adminRepo;
	
	@Autowired
	private ICustomerRepository customerRepo;
	
	@Autowired
	private ITripBookingRepository tripRepo;
	
	@Autowired
	private ICabRepository cabRepo;
	
	
	
	
	@Override
	public Admin getAdminById(int adminId) {

		//return adminRepo.findById(adminId).get();
		
		Optional<Admin> opt= adminRepo.findById(adminId);
		
		if(opt.isPresent()) {
			Admin admin= opt.get();
			return admin;
		}
		else
			throw new AdminNotFoundException("Admin does not exist with the Id");
		
		
		
	}
	
	@Override
	public Admin insertAdmin(Admin admin) {
		return adminRepo.save(admin);
		
	}
	@Override
	public Admin updateAdmin(Admin admin) {
		

		Optional<Admin> opt= adminRepo.findById(admin.getAdminId());
		
		if(opt.isPresent()) {
			
			return adminRepo.save(admin);
		
		}
		else
			throw new AdminNotFoundException("Admin does not exist with the Id");
		
	}
	
	
	@Override
	public List<Admin> deleteAdmin(int adminId) {
	
		Optional<Admin> opt= adminRepo.findById(adminId);
		
		if(opt.isPresent()) {
			Admin admin= opt.get();
			adminRepo.delete(admin);
			
			return adminRepo.findAll();
			
		}
		else
			throw new AdminNotFoundException("Admin does not exist with the Id");
		
	}
	
	
	
	@Override
	public List<TripBooking> getAllTrips(int customerId)  {
		
		Optional<Customer> opt= customerRepo.findById(customerId);
		
		
		if(opt.isPresent()) {
			
			Customer customer= opt.get();
			
			return customer.getTripBookings();
			
		}
		else
			throw new CustomerNotFoundException("Customer does not exist..");
		
		
	}
	@Override
	public List<TripBooking> getTripsCabwise(Integer cabId) {
		
		Optional<Cab> opt= cabRepo.findById(cabId);
		
		if(opt.isPresent()) {
			
			Cab cab= opt.get();
			return cab.getDriver().getTripBookings();
			
		}else
			throw new CabNotFoundException("Invalid Cab Id");
		
	}
	@Override
	public List<TripBooking> getTripsCustomerwise(Integer customerId) {
		
		Optional<Customer> opt= customerRepo.findById(customerId);
		
		if(opt.isPresent()) {
			Customer customer = opt.get();
			return customer.getTripBookings();
			
		}else 
			throw new CustomerNotFoundException("Invalid CustometId");
		
	}
	
	@Override
	public List<TripBooking> getTripsDatewise() {
		return tripRepo.findAll();
	}
	
	
	
	
	@Override
	public List<TripBooking> getAllTripsforDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		
		
		Optional<Customer> opt= customerRepo.findById(customerId);
		
		if(opt.isPresent()) {
			
			Customer customer= opt.get();
			
			List<TripBooking> trips= customer.getTripBookings();
			
			List<TripBooking> filteredTrips=new ArrayList<TripBooking>();
			
			for(TripBooking trip:trips) {
				
				if(trip.getFromDateTime().equals(fromDate) && trip.getToDateTime().equals(toDate)) {
					
					filteredTrips.add(trip);
					
				}
				
			}
			
			
			return filteredTrips;
			
		}
		else
			throw new CustomerNotFoundException("Invalid Customer Id");
		
		
		
		
	}
public Admin validateAdmin(String username, String password) {
		
		
		Admin admin=adminRepo.findByUsernameAndPassword(username, password);
		
	
		if (admin==null) throw new AdminNotFoundException("Invalid Username Or Password");
		else
			return admin;
		
		
	} 

}
