package com.cg.app.service;

import java.util.List;

import com.cg.app.entities.Customer;
import com.cg.app.exception.CustomerNotFoundException;

public interface ICustomerService {
	
	public Customer insertCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer deleteCustomer(Customer customer);
	
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId);
	public Customer validateCustomer(String username, String password);
	
	

	

}
