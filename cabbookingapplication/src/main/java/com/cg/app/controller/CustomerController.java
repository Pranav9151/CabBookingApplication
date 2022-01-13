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

import com.cg.app.entities.Customer;
import com.cg.app.entities.Login;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.InvalidUserOrPasswordException;
import com.cg.app.service.ICustomerService;
//import com.cg.app.service.LoginService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	//@Autowired
	//LoginService loginService;
	/*@PostMapping("/login")
	public Customer loginCustomer(@RequestBody Login login) {
		
		if(login.getRole().equals("customer")) {
			

		return loginService.loginService(login.getUsername(),login.getPassword());
		
	}
		else
			throw new CustomerNotFoundException("Invalid Role...");
	}*/
		
		
	@PostMapping()
	public Customer insertCustomer(@RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}
	
	@SuppressWarnings("unused")
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer cViewer=null;
			cViewer = viewCustomer(customer.getCustomerId());
			return customerService.updateCustomer(customer);
	}
	@SuppressWarnings("unused")
	@DeleteMapping
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		
		Customer cViewer = null;
			cViewer = viewCustomer(customer.getCustomerId());
			return customerService.deleteCustomer(customer);
		
	}
	@GetMapping(value = "all")
	public List<Customer> viewCustomers() {
		return customerService.viewCustomers();
	}

	@GetMapping(value = "/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
		return customerService.viewCustomer(customerId);
		
	}
	
	
	
	

	}