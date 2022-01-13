package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Login;


import com.cg.app.entities.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login,Object>
{
	public String validateCredintials(Object obj);

public interface LoginRepo extends JpaRepository< Login ,String > {

}
}