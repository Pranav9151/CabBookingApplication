package com.cg.app.service;

import com.cg.app.entities.Customer;

public interface LoginService {
	public String validateCredintials(Object obj);

	public Customer loginService(String username, String password);

	

}
