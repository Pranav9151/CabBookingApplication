package com.cg.app.entities;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Login {
	
	private String username;
	private String password;
	private String role;
	
	
}
