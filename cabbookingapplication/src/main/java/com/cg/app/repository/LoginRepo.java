package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Repository;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Login;
>>>>>>> branch 'master' of https://github.com/Pranav9151/CabBookingApplication.git

<<<<<<< HEAD
import com.cg.app.entities.Login;
=======
@Repository
public interface LoginRepo extends JpaRepository<Login,Object>
{
	public String validateCredintials(Object obj);
>>>>>>> branch 'master' of https://github.com/Pranav9151/CabBookingApplication.git

public interface LoginRepo extends JpaRepository< Login ,String > {

}