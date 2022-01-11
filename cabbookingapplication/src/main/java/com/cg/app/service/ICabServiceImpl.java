package com.cg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Admin;
import com.cg.app.entities.Cab;
import com.cg.app.entities.Driver;
import com.cg.app.exception.AdminNotFoundException;
import com.cg.app.exception.CabNotFoundException;
import com.cg.app.exception.DriverNotFoundException;
import com.cg.app.repository.ICabRepository;

@Service
public class ICabServiceImpl implements ICabService{

	@Autowired
	private ICabRepository cabRepo;
	
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
		
		return null;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) {
	
		return null;
	}

	@Override
	public int countCabsOfType(String carType) {
	
		return 0;
	}

	@Override
	public Cab getCabById(int cabID) {
	
		return null;
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
