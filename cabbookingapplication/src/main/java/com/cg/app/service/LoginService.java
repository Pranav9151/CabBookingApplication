package com.cg.app.service;

import com.cg.app.entities.Customer;
import com.cg.app.entities.Driver;

public interface LoginService {

	String validateCredintials(Driver driver);

	Customer loginService(String username, String password);

	String validateCredintials(Object obj);

}
