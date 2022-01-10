package com.cg.app.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Admin;
import com.cg.app.entities.TripBooking;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.repository.IAdminRepository;

@Service("ias")
public class IAdminServiceImpl  implements IAdminService{
	@Autowired
	IAdminRepository aDao;
	@Override
	public Admin getAdminById(int adminId) {

		return aDao.findById(adminId).get();
	}
	
	@Override
	public Admin insertAdmin(Admin admin) {
		aDao.saveAndFlush(admin);
		return admin;
	}
	@Override
	public Admin updateAdmin(Admin admin) {
		aDao.saveAndFlush(admin);
		return admin;
	}
	@Override
	public List<Admin> deleteAdmin(int adminId) {
		aDao.deleteById(adminId);
		return aDao.findAll();
	}
	@Override
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException {
		return aDao.getAllTrips(customerId);
	}
	@Override
	public List<TripBooking> getTripsCabwise() {
		return aDao.getTripsCabwise();
	}
	@Override
	public List<TripBooking> getTripsCustomerwise() {
		return aDao.getTripsCustomerwise();
	}
	@Override
	public List<TripBooking> getTripsDatewise() {
		return aDao.getTripsDatewise();
	}
	@Override
	public List<TripBooking> getAllTripsforDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException {
		return aDao.getAllTripsForDays(customerId, fromDate, toDate);
	}


}
