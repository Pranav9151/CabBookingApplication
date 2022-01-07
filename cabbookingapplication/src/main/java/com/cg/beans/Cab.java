package com.cg.beans;

public class Cab {
	
	private int cabId;
	private String carType;
	private float perkmRate;
	public Cab(int cabId, String carType, float perkmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perkmRate = perkmRate;
	}
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerkmRate() {
		return perkmRate;
	}
	public void setPerkmRate(float perkmRate) {
		this.perkmRate = perkmRate;
	}
	
	

}
