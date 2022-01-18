package com.cg.app.entities;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	
	
	private String username;
	private String password;
	private String role;
	
	 public String getRole(){
		 return this.role;
	}
	 public String getpassword(){
		 return this.password;
	}
	 public String getusername(){
		 return this.username;
	}
	 
	 
	
	
	
	
	
}
