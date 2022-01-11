package com.cg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.LoginDao;

@Service("ls")
public class LoginServiceImpl  implements LoginService {
	
		@Autowired
		LoginRepo ld;

		@Override
		public String validateCredintials(Object obj) {

			return ld.validateCredintials(obj);
		}

}
