package com.cg.app.controller;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.cg.app.entities.TripBooking;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.InvalidUserOrPasswordException;
import com.cg.app.service.IAdminService;
import com.cg.app.service.ICustomerService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IAdminService adminService;

	//@Autowired
	//LoginService loginService;

	@Autowired
	ICustomerService customerService;
	/*@PostMapping("/login")
	public String validateAdmin(@RequestBody Admin admin)  {
		
		
			return loginService.validateCredintials(admin);
		
	}*/
	
	@PostMapping
	public Admin insertAdmin(@RequestBody Admin admin) {
		return adminService.insertAdmin(admin);
	}

	@DeleteMapping("/{adminId}")
	public List<Admin> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException {
		
		return adminService.deleteAdmin(adminId);

		
	}
		@PutMapping
		public Admin updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
			
			//ias.getAdminById(admin.getAdminId());
			return	adminService.updateAdmin(admin);
			
		}
		@GetMapping("/{adminId}")
		public Admin GetAdminById(@PathVariable int adminId) throws AdminNotFoundException {
			
				return adminService.getAdminById(adminId);

			
		}
		
		
		@SuppressWarnings("unused")
		@GetMapping("/alltrips/{customerId}")
		public List<TripBooking> getAllTrips(@PathVariable int customerId) throws CustomerNotFoundException {

			//c= cusService.viewCustomer(customerId);
			return adminService.getAllTrips(customerId);
			
		}
		
		/*@GetMapping("/customerwise")
		public List<TripBooking> getTripsCustomerwise() {
			return adminService.getTripsCustomerwise(int customerId);
		}*/
		
		
		@GetMapping("/datewise")
		public List<TripBooking> getTripsDatewise() {
			return adminService.getTripsDatewise();
		}
		@GetMapping("fordays/{customerId}/{fromDate}/{toDate}")
		public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId,
				@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
				@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate)
				throws CustomerNotFoundException {
			return adminService.getAllTripsforDays(customerId, fromDate, toDate);
		}


}
