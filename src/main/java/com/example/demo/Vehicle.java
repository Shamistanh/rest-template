package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Vehicle {

	private @Id @GeneratedValue Long id;
	private String manufacturer;
	private String model;
	private String modelYear;
	private String vehicleType;
	private String gearbox;
	private String fuelType;

    public Vehicle() {

    }

    public Vehicle(String manufacturer, String model, String modelYear, String vehicleType, String gearbox, String fuelType) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.modelYear = modelYear;
        this.vehicleType = vehicleType;
        this.gearbox = gearbox;
        this.fuelType = fuelType;
    }


    public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}





	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

  public String getModelYear(){
    return this.modelYear;
  }
  public void setModelYear(String modelYear){
    this.modelYear = modelYear;
  }

  public String getVehicleType(){
    return this.vehicleType;
  }

  public void setVehicleType(String vehicleType){
    this.vehicleType = vehicleType;
  }
  
  public String getGearbox(){
    return this.gearbox;
  }
  
  public void setGearbox(String gearbox){
    this.gearbox = gearbox;
  }
  
  public String getFuelType(){
    return this.fuelType;
  }
  
  public void setFuelType(String fuelType){
    this.fuelType = fuelType;
  }
	// TO BE COMPLETED
}
