package com.cg.app.entities;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractUser {

	private String username;
	private String password;
	private String mobileNumber;
	private String email;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password =password ;
	}
	
	
	
	
	
	
	
	}
	


