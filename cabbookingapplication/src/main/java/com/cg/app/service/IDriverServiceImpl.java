package com.cg.app.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Driver;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.DriverNotFoundException;
import com.cg.app.repository.IDriverRepository;

@Service
public class IDriverServiceImpl implements IDriverService{

@Autowired
	IDriverRepository driverRepo;


@Override
	public List<Driver> displayAllDriver() {
		return driverRepo.findAll();
	}


	@Override
	public Driver viewDriver(int driverId)  {

		Optional<Driver> opt= driverRepo.findById(driverId);
		
		if(opt.isPresent()) {
			Driver driver= opt.get();
			return driver;
		}
		else
			throw new DriverNotFoundException("Driver does not exist with the Id");
	}
	
	
	@Override
	public List<Driver> viewBestDrivers() {
		List<Driver> bestDrivers = driverRepo.findAll();
		return bestDrivers.stream().filter((d) -> d.getRating() >= 4.5).collect(Collectors.toList());
	}

	@Override
	public Driver insertDriver(Driver driver) {
		return driverRepo.save(driver);
		
	}

	@Override
	public Driver updateDriver(Driver driver)  {
		
		Optional<Driver> opt= driverRepo.findById(driver.getDriverId());
		
		if(opt.isPresent()) {
			
			return driverRepo.save(driver);
		
		}
		else
			throw new DriverNotFoundException("Driver does not exist with the Id");
		
	}
	
	@Override
	public List<Driver> deleteDriver(int driverId)  {

		Optional<Driver> opt= driverRepo.findById(driverId);
		
		if(opt.isPresent()) {
			Driver driver= opt.get();
			driverRepo.delete(driver);
			
			return driverRepo.findAll();
			
		}
		else
			throw new DriverNotFoundException("Driver does not exist with the Id");
		
	}
public Driver validateDriver(String username, String password) {
		
		
		Driver driver=driverRepo.findByUsernameAndPassword(username, password);
		
	
		if (driver==null) throw new CustomerNotFoundException("Invalid Username Or Password");
		else
			return driver;
		
		
	} 

}
