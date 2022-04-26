package com.example.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class VehicleController {

	private final VehiclesRepository repository;

	private final VehicleModelAssembler assembler;

	VehicleController(VehiclesRepository repository, VehicleModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}

  @GetMapping("/cars") // GET HTTP Method   GET /cars
  List<VehicleDTO> all() {
     return repository.findAll().stream().map(model->{
         VehicleDTO dto = new VehicleDTO();
         dto.setGearbox(model.getGearbox());
         dto.setVehicle(model.getManufacturer()+"-"+model.getModel());
         dto.setId(model.getId());
         dto.setVehicleType(model.getVehicleType());
         dto.setModelYear(model.getModelYear());
         dto.setFuelType(model.getFuelType());
         return dto;
     }).collect(Collectors.toList());
  }

  // GET HTTP Method GET /cars/{id}
  @GetMapping("/cars/{id}")
  VehicleDTO one(@PathVariable Long id) {
      Vehicle vehicle = repository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
      VehicleDTO vehicleDTO = new VehicleDTO();
      vehicleDTO.setVehicle(vehicle.getManufacturer() +"-"+vehicle.getModel());
      vehicleDTO.setFuelType(vehicle.getFuelType());
      vehicleDTO.setModelYear(vehicle.getModelYear());
      vehicleDTO.setId(vehicle.getId());
      vehicleDTO.setGearbox(vehicle.getGearbox());
      return vehicleDTO;
  }

  // POST HTTP Method POST /cars
  @PostMapping("/cars")
  Vehicle newVehicle(@RequestBody VehicleDTO newVehicle) {
	    Vehicle vehicle = new Vehicle();
	    vehicle.setManufacturer(newVehicle.getVehicle().split("-")[0]);
         vehicle.setModel(newVehicle.getVehicle().split("-")[1]);
         vehicle.setFuelType(newVehicle.getFuelType());
         vehicle.setId(newVehicle.getId());
         vehicle.setGearbox(newVehicle.getGearbox());
	    vehicle.setModel(newVehicle.getVehicle());
    return repository.save(vehicle);
  }

  // PUT HTTP Method PUT /cars/{id}
  @PutMapping("cars/{id}")
  Vehicle replaceVehicle(@RequestBody Vehicle newVehicle, @PathVariable Long id) {
      Optional<Vehicle> byId = repository.findById(id);
      if (byId.isPresent()){
          newVehicle.setId(id);
          repository.save(newVehicle);
      }
      return newVehicle;
  }

  // DELETE HTTP Method DELETE /cars/{id}
  @DeleteMapping("cars/{id}")
  void deleteVehicle(@PathVariable Long id) {
    repository.deleteById(id);
  }

	// TO BE COMPLETED
	
}

