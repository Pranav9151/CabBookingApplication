package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.cg.app.entities.Admin;
import com.cg.app.entities.Driver;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByUsernameAndPassword(String username, String password);
}
