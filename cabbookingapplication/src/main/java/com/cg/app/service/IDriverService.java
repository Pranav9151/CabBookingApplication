package com.cg.app.service;

import java.util.List;

import com.cg.app.entities.Driver;
import com.cg.app.exception.DriverNotFoundException;

public interface IDriverService {
	
	public List<Driver> displayAllDriver();
	
	public Driver viewDriver(int driverId) throws DriverNotFoundException;
	
	public List<Driver> viewBestDrivers() throws DriverNotFoundException;
	
	public List<Driver> insertDriver(Driver driver);
	
	public Driver updateDriver(Driver driver) throws DriverNotFoundException;
	
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException;

}
