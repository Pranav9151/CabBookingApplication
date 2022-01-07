package com.cg.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public Admin(int adminId) {
		super();
		this.adminId=adminId;
	}

	
}
