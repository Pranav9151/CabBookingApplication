package com.cg.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cab {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cabId;
	
	private String carType;
	private float perkmRate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Driver driver;
	
	public int getCabId() {
		return this.cabId;
	}
	public Driver getDriver() {
		return this.driver;
	}

}
