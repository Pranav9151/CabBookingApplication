package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.entities.Admin;
import com.cg.app.entities.TripBooking;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.TripBookingNotFoundException;
import com.cg.app.service.ITripBookingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tripbooking")
public class TripBookingController {
	
	@Autowired
	ITripBookingService tripBookingService;
	
	@PostMapping("/register")
	public ResponseEntity <TripBooking>  inserTripBooking(@RequestBody TripBooking tripBooking) {
		TripBooking tripst=tripBookingService.insertTripBooking(tripBooking);
		return  new ResponseEntity<TripBooking>(tripst,HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<TripBooking>updateTripBooking(@RequestBody TripBooking tripBooking)throws TripBookingNotFoundException{
		TripBooking tripst=tripBookingService.updateTripBooking(tripBooking);
			return  new ResponseEntity<TripBooking>(tripst,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{adminId}")
	public List<TripBooking> deleteTripBooking(@PathVariable int tripBookingId)throws AdminNotFoundException  {
		List<TripBooking> tripst=tripBookingService.deleteTripBooking(tripBookingId);
		
		return	tripst;

	}
	@GetMapping("/alltrips/{customerId}")
	public List<TripBooking> viewAllTripsCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
			List<TripBooking> tripList =tripBookingService.viewAllTripsCustomer(customerId);
	return	 tripList;
		
	}
	
	@GetMapping("/alltrips/{tripBookingId}")
	public List<TripBooking> viewAllTripsById(@PathVariable int tripBookingId)throws TripBookingNotFoundException {
			List<TripBooking> tripList =tripBookingService.viewAllTripsById(tripBookingId);
	return	 tripList;
		
	}

}
