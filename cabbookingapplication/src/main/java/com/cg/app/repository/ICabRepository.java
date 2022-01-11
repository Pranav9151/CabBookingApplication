package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.app.entities.Cab;

@Repository
public interface ICabRepository extends JpaRepository<Cab, Integer> {

}
