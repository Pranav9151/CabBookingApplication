package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.cg.app.entities.Driver;


@Repository
public interface IDriverRepository extends JpaRepository<Driver, Integer> {

	


}
