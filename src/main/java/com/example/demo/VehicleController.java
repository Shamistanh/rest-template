package com.example.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;
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
  List<Vehicle> all() {
    return repository.findAll();
  }

  // GET HTTP Method GET /cars/{id}
  @GetMapping("/cars/{id}")
  Vehicle one(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
  }

  // POST HTTP Method POST /cars
  @PostMapping("/cars")
  Vehicle newVehicle(@RequestBody Vehicle newVehicle) {
    return repository.save(newVehicle);
  }

  // PUT HTTP Method PUT /cars/{id}
  @PutMapping("cars/{id}")
  Vehicle replaceVehicle(@RequestBody Vehicle newVehicle, @PathVariable Long id) {
    return new Vehicle();
    // Finish
  }

  // DELETE HTTP Method DELETE /cars/{id}
  @DeleteMapping("cars/{id}")
  void deleteVehicle(@PathVariable Long id) {
    repository.deleteById(id);
  }

	// TO BE COMPLETED
	
}

