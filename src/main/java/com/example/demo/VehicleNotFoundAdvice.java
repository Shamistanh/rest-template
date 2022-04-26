package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class VehicleNotFoundAdvice {

	// TO BE COMPLETED
  @ResponseBody
	@ExceptionHandler(VehicleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
	String vehicleNotFoundHandler(VehicleNotFoundException ex) {
		return ex.getMessage();
	}
}