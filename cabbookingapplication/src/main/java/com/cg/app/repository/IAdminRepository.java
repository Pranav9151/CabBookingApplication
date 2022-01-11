package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.cg.app.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
