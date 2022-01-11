package com.cg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Cab;
import com.cg.app.entities.Customer;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CabNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.repository.ICustomerRepository;


@Service("customerSer")
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerservice;

	 private  ICustomerRepository customerRepo;
	

	@Override
	public Customer insertCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		

		Optional<Customer> opt= customerRepo.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			
			return customerRepo.save(customer);
		
		}
		else
			throw new CustomerNotFoundException("Customer does not exist with the Id");
			
	}

	@Override
	public Customer deleteCustomer(Customer customer) {

		Optional<Customer> opt= customerRepo.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
		customerRepo.delete(customer);
			return customer;
		}
		else
			throw new CustomerNotFoundException("Customer does not exist with the Id");
		
	}

	@Override
	public List<Customer> viewCustomers() {
	
	 return customerRepo.findAll();
	 
		
		
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		
		
		Customer customer=customerRepo.findByUsernameAndPassword(username, password);
		
	
		if (customer==null) throw new CustomerNotFoundException("Invalid Username Or Password");
		else
			return customer;
		
		
	} 
	
	@Override
	public Customer viewCustomer(int customerId) {

		Optional<Customer> opt= customerRepo.findById(customerId);
		
		if(opt.isPresent()) {
			Customer customer= opt.get();
			return customer;
		}
		else
			throw new CustomerNotFoundException("Customer does not exist with the Id");
		
	}
	
	
	
	

}
