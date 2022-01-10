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
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.InvalidUserOrPasswordException;
import com.cg.app.service.ICustomerService;
import com.cg.app.service.LoginService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService cusService;
	@Autowired
	LoginService ls;
	@PostMapping("/login")
	public String validateCustomer(@RequestBody Customer customer) {

		return ls.validateCredintials(customer);
	}
	@PostMapping
	public Customer insertCustomer(@RequestBody Customer customer) {
		return cusService.insertCustomer(customer);
	}
	@SuppressWarnings("unused")
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		
			cViewer = viewCustomer(customer.getCustomerId());
			c = cusService.updateCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found to perform Update Operation!");
		}
		return c;
	}
	@SuppressWarnings("unused")
	@DeleteMapping
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		Customer cViewer = null;
		Customer c = null;
		try {
			cViewer = viewCustomer(customer.getCustomerId());
			c = cusService.deleteCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found to perform Delete Operation!");
		}
		return c;
	}
	@GetMapping(value = "all")
	public List<Customer> viewCustomers() {
		return cusService.viewCustomers();
	}

	@GetMapping(value = "/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
		Customer c = null;
		try {
			c = cusService.viewCustomer(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer with Id: " + customerId + " Not Found!");
		}
		return c;
	}
	
	
	
	

	}