package com.cg.app.dao;

import java.util.List;

import com.cg.app.entities.Customer;
import com.cg.app.exception.CustomerNotFoundException;


public interface ICustomerDao {
public List<Customer> viewCustomers();
	
	public Customer viewCustomer(int CustomerId) throws CustomerNotFoundException;
	
	public Customer validateCustomer(String username,String password) throws CustomerNotFoundException;

}
