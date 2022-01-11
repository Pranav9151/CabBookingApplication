package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.app.entities.TripBooking;

@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking, Integer> {

}
