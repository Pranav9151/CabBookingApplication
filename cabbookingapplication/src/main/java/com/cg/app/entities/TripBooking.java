package com.cg.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tripBookingId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver driver;
	
	private String fromLocation;

	private String toLocation;
	@JsonFormat(pattern = "dd-mm-yy")
	private LocalDate fromDateTime;
	@JsonFormat(pattern = "dd-mm-yy")
	private LocalDate toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
	
	public LocalDate getFromDateTime() {
		return this.fromDateTime;
	}
	public LocalDate getToDateTime() {
		return this.toDateTime;
	}
	public int getTripBookingId() {
		return this.tripBookingId;
	}
	public Customer getCustomer() {
		return this.customer;
	}

}
