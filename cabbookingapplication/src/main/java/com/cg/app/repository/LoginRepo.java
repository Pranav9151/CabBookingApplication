package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.entities.Login;

public interface LoginRepo extends JpaRepository< Login ,String > {

}