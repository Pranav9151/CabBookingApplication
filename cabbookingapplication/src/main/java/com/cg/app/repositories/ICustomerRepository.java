package com.cg.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByCustomerId(Integer CustomerId);
	

}
