package com.cg.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {
	
	private LocalDateTime timestamp;
	private String details;
	private String message;
	public void setStatus(HttpStatus badRequest) {
		// TODO Auto-generated method stub
		
	}
	

}
