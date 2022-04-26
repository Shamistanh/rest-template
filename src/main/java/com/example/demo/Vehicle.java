package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Vehicle {

	private @Id @GeneratedValue Long id;
	private String vehicle;
	private String modelYear;
	private String vehicleType;
	private String gearbox;
	private String fuelType;

	Vehicle() {}

	Vehicle(String vehicle, String modelYear, String vehicleType, String gearbox, String fuelType) {
		this.vehicle = vehicle;
		this.modelYear = modelYear;
		this.vehicleType = vehicleType;
		this.gearbox = gearbox;
		this.fuelType = fuelType;
	}

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

  public String getvehicle() {
    return this.vehicle;
  }

  public void setvehicle(String vehicle) {
    this.vehicle = vehicle;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Vehicle))
			return false;
		Vehicle v = (Vehicle) o;
		return Objects.equals(this.id, v.id) && Objects.equals(this.vehicle, v.vehicle)
				&& Objects.equals(this.modelYear, v.modelYear) && Objects.equals(this.vehicleType, v.vehicleType)
				&& Objects.equals(this.gearbox, v.gearbox) && Objects.equals(this.fuelType, v.fuelType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.vehicle, this.modelYear, this.vehicleType, this.gearbox, this.fuelType);
	}

	@Override
	public String toString() {
		return "Vehicle {" + "id=" + this.id + ", vehicle='" + this.vehicle + '\'' + ", modelYear='" + this.modelYear
				+ '\'' + ", vehicleType='" + this.vehicleType + '\'' + ", Gearbox='" + this.gearbox + '\'' +
				", fuelType='" + this.fuelType + '\'' + '}';
	}
}
