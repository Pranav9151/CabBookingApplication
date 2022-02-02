package com.cg.app.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cg.app.exception.CustomErrorResponse;
import com.cg.app.exception.CustomerNotFoundException;
import com.cg.app.exception.InvalidUserOrPasswordException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleEmployeeException(CustomerNotFoundException ex,WebRequest req){
		CustomErrorResponse customResponse=new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<CustomErrorResponse>(customResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserOrPasswordException.class)
	public ResponseEntity<CustomErrorResponse> InvalidException(InvalidUserOrPasswordException ivd,WebRequest req){
		CustomErrorResponse customResponse=new CustomErrorResponse(LocalDateTime.now(), ivd.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomErrorResponse>(customResponse,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorResponse>myExceptionhandler(Exception ex,WebRequest req){
		CustomErrorResponse customResponse=new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomErrorResponse>(customResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){
		
		CustomErrorResponse resp=new CustomErrorResponse();
		resp.setTimestamp(LocalDateTime.now());
		resp.setMessage(exp.getBindingResult().getFieldError().getDefaultMessage());
		resp.setStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
