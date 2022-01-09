package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Customer;
import com.cg.app.repository.CustomerRepository;

@Service("customerSer")
public class ICustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerservice;

	@Override
	public Customer insertCustomer(Customer customer) {
		
		
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		
		return null;
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		customerservice.delete(customer);
		return customer;
	}

	@Override
	public List<Customer> viewCustomer(int customerId) {
		
		return customerservice.findAll();
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		
		return null;
	}
	
	
	
	

}
