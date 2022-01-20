package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Driver;
import com.cg.app.entities.LoginBean;
import com.cg.app.repository.IDriverRepository;
import com.cg.app.service.IDriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	private IDriverService driverService;
	
	@PostMapping("/register")
	public ResponseEntity<Driver> insertDriver(@RequestBody Driver driver) {
		Driver driv=driverService.insertDriver(driver);
		return  new ResponseEntity<Driver>(driv,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Driver>updateDriver(@RequestBody Driver driver){
		Driver  driv=driverService.updateDriver(driver);
			return  new ResponseEntity<Driver>(driv,HttpStatus.OK);
	}
/*@GetMapping( value="/delete/{cid}")
	public Driver deleteDriver(@RequestBody Driver driver)  {
	List<Driver>deleteList=driverService.deleteDriver(0);
			return driverService.deleteDriver(driver);
		
	} */
	@GetMapping("/viewall")
	public List<Driver> viewBestDrivers() {
		List<Driver> drivList=driverService.viewBestDrivers();
		return drivList;
	}

	@GetMapping(value = "/{driverId}")
	public Driver viewDriver(@PathVariable int driverId)  {
		return driverService.viewDriver(driverId);
		
	}
	@GetMapping("/alldrivers")
	public List<Driver> displayAllDrivers() {
		List<Driver> alldriv=driverService.displayAllDriver();
		return alldriv;
	}
	
			
		
	}
	
	


