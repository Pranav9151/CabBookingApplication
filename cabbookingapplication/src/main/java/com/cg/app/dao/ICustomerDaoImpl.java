package com.cg.app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.app.entities.Customer;
import com.cg.app.exception.CustomerNotFoundException;
@Repository
@Transactional
public class ICustomerDaoImpl implements ICustomerDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Customer> viewCustomers(){
		TypedQuery<Customer> q = em.createQuery("select c from Customer c",Customer.class);
		List<Customer> lsCustomers = q.getResultList();
		return lsCustomers;
	}
	
	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException{
		TypedQuery<Customer> q = em.createQuery("select c from Customer c where c.customerId = :cId", Customer.class);
		q.setParameter("cId",customerId);
		List<Customer> lsCustomers = q.getResultList();
		
		if(lsCustomers.size() > 0) {
			return lsCustomers.get(0);
		}
		else {
			throw new CustomerNotFoundException("Customer Id Not Found");
		}
	}
		@Override
		public Customer validateCustomer(String username,String password) throws CustomerNotFoundException
		{
			TypedQuery<Customer> q = em.createQuery("select c from Customer c where c.username=:uname and c.password=:pass", Customer.class);
			q.setParameter("uname",username);
			q.setParameter("pass",password);
			List<Customer> lsCustomers = q.getResultList();
			
			if(lsCustomers.size() > 0) {
				return lsCustomers.get(0);
			}
			else {
				throw new CustomerNotFoundException("Invalid Details");
			}
		}
	}