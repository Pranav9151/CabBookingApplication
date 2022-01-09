package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.app.entities.Customer;

import com.cg.app.repository.CustomerRepository;

import com.cg.app.repositories.ICustomerRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service("customerSer")
public class ICustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerservice;

	 private  ICustomerRepository customerRepo;
	

	@Override
	public Customer insertCustomer(Customer customer) {
		 Customer savedCustomer=customerRepo.save(customer);
		return savedCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer upd= customerRepo.findByCustomerId(customer.getCustomerId()).get();
		if(upd != null) {
			
			upd.setEmail(customer.getEmail());
			upd.setMobileNumber(customer.getMobileNumber());
			upd.setUsername(customer.getUsername());
			upd.setPassword(customer.getPassword());
			customerRepo.save(upd);
		}
		return upd;
		
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		customerRepo.delete(customer);
		return customer;
	}

	@Override
	public List<Customer> viewCustomer(int customerId) {
		
		return customerRepo.findAll();
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		
		return null;
	}
	
	
	
	

}
