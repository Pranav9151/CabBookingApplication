package com.cg.app.entities;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractUser {

	private String username;
	private String password;
	private String mobileNumber;
	private String email;
	
	
	
	
	
	
	}
	


