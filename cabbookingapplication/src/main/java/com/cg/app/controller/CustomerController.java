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
import com.cg.app.entities.LoginBean;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.InvalidUserOrPasswordException;
import com.cg.app.service.ICustomerService;
//import com.cg.app.service.LoginService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	 private ICustomerService customerService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Customer>  insertCustomer(@RequestBody Customer customer) {
		Customer cust=customerService.insertCustomer(customer);
		return  new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Customer>updateCustomer(@RequestBody Customer customer){
		Customer cust=customerService.updateCustomer(customer);
			return  new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public Customer deleteCustomer(@RequestBody Customer customer)  {
			return customerService.deleteCustomer(customer);
		
	}
	@GetMapping("/viewall")
	public List<Customer> viewCustomers() {
		List<Customer> cusList=customerService.viewCustomers();
		return cusList;
	}

	@GetMapping(value = "/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId)  {
		return customerService.viewCustomer(customerId);
		
	}
	
	@PostMapping("/login")
	public Customer loginCustomerHandler(@RequestBody LoginBean login)throws CustomerNotFoundException {
		
	 	return customerService.validateCustomer(login.getusername(),login.getpassword());
		
		
	}
	
	

	}