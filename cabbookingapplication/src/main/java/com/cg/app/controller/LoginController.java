package com.cg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Driver;
import com.cg.app.exception.InvalidUserOrPasswordException;
import com.cg.app.service.LoginServiceImpl;

@RestController
@RequestMapping("/login/")
public class LoginController {
	@Autowired
	LoginServiceImpl lServiceImpl;
	@GetMapping("/customer/{username}/{password}")
	public String customerLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {
		
			Customer customer = new Customer();
			customer.setUsername(username);
			customer.setPassword(password);

			return lServiceImpl.validateCredintials(customer);
		

	}

	@GetMapping("/admin/{username}/{password}")
	public String adminLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {

	
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			return lServiceImpl.validateCredintials(admin);
		

	}

	@GetMapping("/driver/{username}/{password}")
	public String driverLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {

		
			Driver driver = new Driver();
			driver.setUsername(username);
			driver.setPassword(password);
			return lServiceImpl.validateCredintials(driver);
		

	}
}
