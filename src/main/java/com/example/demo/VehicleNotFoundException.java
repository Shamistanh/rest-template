package com.example.demo;

class VehicleNotFoundException extends RuntimeException {

	VehicleNotFoundException(Long id) {
		super("Could not find vehicle " + id);
	}
}