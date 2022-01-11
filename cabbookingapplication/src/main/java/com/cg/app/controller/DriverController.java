package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.entities.Driver;
import com.cg.app.exception.DriverNotFoundException;
import com.cg.app.exception.InvalidUserOrPasswordException;
import com.cg.app.service.IDriverService;
import com.cg.app.service.LoginService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	IDriverService driverServices;

	@Autowired
	LoginService loginservices;
	@PostMapping("/login")
	public String validateDriver(@RequestBody Driver driver) throws InvalidUserOrPasswordException {
	
		return loginservices.validateCredintials(driver);
		
	}
	
	
	@GetMapping
	public List<Driver> displayAllDrivers() {
		return driverServices.displayAllDriver();
	}
	
	
	@GetMapping("/{driverId}")
	public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
		
		return driverServices.viewDriver(driverId);

		
	}
	@GetMapping("/bestdrivers")
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		
		return driverServices.viewBestDrivers();
		
	}
	@PostMapping
	public List<Driver> insertDriver(@RequestBody Driver driver) {
		return driverServices.insertDriver(driver);
	}
	@SuppressWarnings("unused")
	@PutMapping
	public Driver updateDriver(@RequestBody Driver driver) throws DriverNotFoundException {
		Driver driverCheck = null;
		
			driverCheck = viewDriver(driver.getDriverId());
			return driverServices.updateDriver(driver);
		
	}
	@DeleteMapping("/{driverId}")
	public List<Driver> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		return driverServices.deleteDriver(driverId);
		
	}

}
