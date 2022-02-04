package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.entities.Cab;
import com.cg.app.entities.Customer;
import com.cg.app.entities.LoginBean;
import com.cg.app.exception.CabNotFoundException;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.service.ICabService;
import com.cg.app.service.ICustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	 private ICabService cabService;
	
	@PostMapping("/register")
	public ResponseEntity<Cab>  insertCab(@RequestBody Cab cab)throws CabNotFoundException {
		Cab cabst=cabService.insertCab(cab);
		return  new ResponseEntity<Cab>(cabst,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Cab>updateCab(@RequestBody Cab cab)throws CabNotFoundException{
		Cab cabst=cabService.updateCab(cab);
			return  new ResponseEntity<Cab>(HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public Cab deleteCab(@RequestBody Cab cab)throws CabNotFoundException  {
			return cabService.deleteCab(cab);
		
	}
	@GetMapping("/viewCabsOfType")
	public List<Cab> viewCabsOfType(String carType)throws CabNotFoundException {
		List<Cab> cabList=cabService.viewCabsOfType(carType);
		return cabList;
	}

	@GetMapping(value = "/{cabId}")
	public Cab viewCab(@PathVariable int cabID)throws CabNotFoundException  {
		return cabService.getCabById(cabID);
		
	}
	@DeleteMapping("/delete/{cid}")
	public List<Cab> deleteCabById(@RequestBody int cabID)throws CabNotFoundException  {
		List<Cab> cabList=cabService.deleteCabById(cabID);
			return cabList;
		
	}
	@PostMapping("/login")

	public Cab loginCabrHandler(@RequestBody LoginBean login)throws CabNotFoundException {
		
	 	return cabService.validateCab(login.getCarType());
		
		
	}
}
