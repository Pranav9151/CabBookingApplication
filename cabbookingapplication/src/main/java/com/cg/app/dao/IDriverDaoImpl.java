package com.cg.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.cg.app.entities.Driver;
@Repository
@Transactional
public class IDriverDaoImpl implements IDriverDao{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Driver> viewBestDrivers(){
		TypedQuery<Driver> q = em.createQuery("select d from Driver d",Driver.class);
		List<Driver> lsDriver = q.getResultList();
		
		List<Driver> lstemp = new ArrayList<Driver>();
		
		
		java.util.Iterator it = lsDriver.iterator();
		
		while(it.hasNext()) {
			Driver dr = (Driver)it.next();
			if(dr.getRating() >= 4.5) {
				lstemp.add(dr);
			}
		}
		
		//return whose rating is >=4.5
		return lstemp;
}
	@Override
	public Driver viewDriver(int driverId) {
		TypedQuery<Driver> q = em.createQuery("select d from Driver d where d.driverId=:drvId",Driver.class);
		q.setParameter("drvId", driverId);
		
		List<Driver> lsDriver = q.getResultList();
		
		if(lsDriver.size() > 0) {
			return lsDriver.get(0);
		}
		else {
			return null;
		}
		
	}
}