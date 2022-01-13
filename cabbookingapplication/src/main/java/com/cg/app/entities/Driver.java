package com.cg.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends AbstractUser  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverId;
	private String licenseNo;
	private float rating;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "driver")
	private Cab cab;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "driver")
	private List<TripBooking> tripBookings=new ArrayList<TripBooking>();
	
	public int getDriverId() {
		return this.driverId;
	}
	public float getRating() {
		return this.rating;
	}
	public List<TripBooking> getTripBookings(){
		return this.tripBookings;
	}

}
