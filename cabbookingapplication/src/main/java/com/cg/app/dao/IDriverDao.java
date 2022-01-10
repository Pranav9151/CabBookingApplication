package com.cg.app.dao;

import java.util.List;

import com.cg.app.entities.Driver;

public interface IDriverDao  {
public List<Driver> viewBestDrivers();
	public Driver viewDriver(int driverId);


}
