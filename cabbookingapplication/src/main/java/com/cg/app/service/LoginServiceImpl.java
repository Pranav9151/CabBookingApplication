package com.cg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.entities.Customer;
import com.cg.app.repository.LoginRepo;

@Service("ls")
public class LoginServiceImpl  implements LoginService {
	
		@Autowired
		LoginRepo ld;

		@Override
		public String validateCredintials(Object obj) {

		return ld.validateCredintials(obj);
			
		}

		@Override
		public Customer loginService(String username, String password) {
			// TODO Auto-generated method stub
			return null;
		}

}
