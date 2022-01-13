package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.entities.Cab;
import com.cg.app.exception.CabNotFoundException;
import com.cg.app.service.ICabService;

@RestController
	@RequestMapping("/cab")
	public class CabController {

		@Autowired
		ICabService iCabService;
		

		public Cab insertCab(@RequestBody Cab cab) {
			return iCabService.insertCab(cab);
		}
		
		@PutMapping
		public Cab updateCab(@RequestBody Cab cab) throws CabNotFoundException {
			@SuppressWarnings("unused")
			Cab cabCheck = null;
			
				cabCheck = iCabService.getCabById(cab.getCabId());
				return iCabService.updateCab(cab);
			
		}

		@DeleteMapping
		public Cab deleteCab(Cab cab) throws CabNotFoundException {
			@SuppressWarnings("unused")
			Cab cabCheck = null;
			
				cabCheck = iCabService.getCabById(cab.getCabId());
			return iCabService.deleteCab(cab);
			
		}
		
		
		@DeleteMapping(value = "/{cabId}")
		public List<Cab> deleteCabById(@PathVariable int cabId) throws CabNotFoundException {
			
				return iCabService.deleteCabById(cabId);
			

		}

		//@GetMapping(value = "type/{carType}")
		//public List<Cab> viewCabsOfType(String carType) {
			//return iCabService.viewCabsOfType(carType);
		//}
		
		
		
		@GetMapping(value = "/count/{carType}")
		public int countCabsOfType(@PathVariable String carType) {
			return iCabService.countCabsOfType(carType);
		}
		
		
		
		@GetMapping(value = "/{cabId}")
		public Cab getCabById(@PathVariable int cabId) throws CabNotFoundException {
			
				return iCabService.getCabById(cabId);
			
		}

}
