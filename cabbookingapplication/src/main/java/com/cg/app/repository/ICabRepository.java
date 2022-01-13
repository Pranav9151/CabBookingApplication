package com.cg.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.entities.Cab;

@Repository
public interface ICabRepository extends JpaRepository<Cab, Integer> {
	
	public Optional<Cab> findByCarType(String carType);

}
