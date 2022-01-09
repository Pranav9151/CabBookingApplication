package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.dao.ICustomerDao;
import com.cg.app.entities.Customer;
@Repository("cDao")
public interface ICustomerRepository extends ICustomerDao, JpaRepository<Customer, Integer> {


	
}
