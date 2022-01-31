package com.cg.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.cg.app.entities.Admin;
import com.cg.app.entities.Customer;
import com.cg.app.entities.LoginBean;
import com.cg.app.entities.TripBooking;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CabNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.InvalidUserOrPasswordException;
import com.cg.app.service.IAdminService;
import com.cg.app.service.ICustomerService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IAdminService adminService;


	@PostMapping("/register")
	public ResponseEntity<Admin>  insertAdmin(@RequestBody Admin admin)throws AdminNotFoundException {
		Admin adst=adminService.insertAdmin(admin);
		return  new ResponseEntity<Admin>(adst,HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Admin>updateAdmin(@RequestBody Admin admin)throws AdminNotFoundException{
		Admin adst=adminService.updateAdmin(admin);
			return  new ResponseEntity<Admin>(adst,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{adminId}")
	public List<Admin> deleteAdmin(@PathVariable int adminId)throws AdminNotFoundException  {
		List<Admin> adst=adminService.deleteAdmin(adminId);
		
		return	adst;

	}
	
		@GetMapping("/{adminId}")
		public Admin GetAdminById(@PathVariable int adminId)throws AdminNotFoundException {
			return adminService.getAdminById(adminId);

			
		}
		
		@GetMapping("/alltrips/{customerId}")
		public List<TripBooking> getAllTrips(@PathVariable int customerId)throws CustomerNotFoundException  {
				List<TripBooking> adList =adminService.getAllTrips(customerId);
		return	 adList;
			
		}
		
		@GetMapping("/tripsCabWise/{cabId}")
		public List<TripBooking> getTripsCabwise(@PathVariable int cabId)throws CabNotFoundException  {
				List<TripBooking> adList =adminService.getTripsCabwise(cabId);
		return	 adList;
			
		}
		@GetMapping("/customerwise/{customerId}")
		public List<TripBooking> getTripsCustomerwise(@PathVariable Integer customerId)throws CustomerNotFoundException {
			List<TripBooking> adList =adminService.getTripsCustomerwise(customerId);
			return adList;
		}
		
		@GetMapping("/datewise")
		public List<TripBooking> getTripsDatewise() {
			List<TripBooking> adList= adminService.getTripsDatewise();
			return adList;
		}
		
		@GetMapping("fordays/{customerId}/{fromDate}/{toDate}") 
		public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId,
				@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
				@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate)
			 {
			return adminService.getAllTripsforDays(customerId, fromDate, toDate);
		}


}
