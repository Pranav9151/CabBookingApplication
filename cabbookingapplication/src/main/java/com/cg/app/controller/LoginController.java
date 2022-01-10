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
		try {
			Customer customer = new Customer();
			customer.setUsername(username);
			customer.setPassword(password);

			return lServiceImpl.validateCredintials(customer);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}

	@GetMapping("/admin/{username}/{password}")
	public String adminLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {

		try {
			Admin admin = new Admin(0);
			admin.setUsername(username);
			admin.setPassword(password);
			return lServiceImpl.validateCredintials(admin);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}

	@GetMapping("/driver/{username}/{password}")
	public String driverLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {

		try {
			Driver driver = new Driver(0, password, 0, null);
			driver.setUsername(username);
			driver.setPassword(password);
			return lServiceImpl.validateCredintials(driver);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}
}
