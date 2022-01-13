package com.cg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Cab;
import com.cg.app.entities.Customer;
import com.cg.app.entities.Driver;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CabNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.DriverNotFoundException;
import com.cg.app.repository.ICabRepository;
import com.cg.app.repository.IDriverRepository;

@Service
public class ICabServiceImpl implements ICabService{

	@Autowired
	private ICabRepository cabRepo;
	
	@Autowired
	private IDriverRepository driverRepo;
	
	@Override
		public Cab insertCab(Cab cab) {
			return cabRepo.save(cab);
	}

	@Override
	public Cab updateCab(Cab cab) {
		
		Optional<Cab> opt= cabRepo.findById(cab.getCabId());
		
		if(opt.isPresent()) {
			
			return cabRepo.save(cab);
		
		}
		else
			throw new CabNotFoundException("CaB does not exist with the Id");
		
	}

	@Override
	public Cab deleteCab(Cab cab) {
		

		Optional<Cab> opt= cabRepo.findById(cab.getCabId());
		
		if(opt.isPresent()) {
		cabRepo.delete(cab);
			return cab;
		}
		else
			throw new CabNotFoundException("Cab does not exist with the Id");
		
	}

	@Override
    public List<Cab> viewCabsOfType(String carType) {
		
      Optional<Cab> opt= cabRepo.findByCarType(carType);
	
		if(opt.isPresent()) {
		
			Cab cab= opt.get();
			return cabRepo.findAll();
			
	}else
			throw new CabNotFoundException("Invalid Cab type");
		
	}
	
	

	@Override
	public int countCabsOfType(String carType) {
	
		return 0;
	}

	@Override
	public Cab getCabById(int cabID) {
     Optional<Cab> opt= cabRepo.findById(cabID);
		
		if(opt.isPresent()) {
			Cab cab= opt.get();
			return cab;
		}
		else
			throw new CabNotFoundException("cab does not exist with the Id");
		
		
	}

	@Override
	public List<Cab> deleteCabById(int cabID) {
	

		Optional<Cab> opt= cabRepo.findById(cabID);
		
		if(opt.isPresent()) {
			Cab cab= opt.get();
			cabRepo.delete(cab);
			
			return cabRepo.findAll();
			
		}
		else
			throw new CabNotFoundException("Cab does not exist with the Id");
		
	}

}
