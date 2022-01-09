package com.cg.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.app.entities.Driver;
import com.cg.app.exception.DriverNotFoundException;

@Service
public class IDriverServiceImpl implements IDriverService{

	@Override
	public List<Driver> displayAllDriver() {
		
		
		
		return null;
	}

	@Override
	public Driver viewdriver(int driverId) throws DriverNotFoundException {


		
		return null;
	}

	@Override
	public List<Driver> viewBestDriver() throws DriverNotFoundException {


		
		return null;
	}

	@Override
	public List<Driver> insertDriver(Driver driver) {


		
		return null;
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverNotFoundException {


		
		return null;
	}

	@Override
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException {


		
		return null;
	}

}
