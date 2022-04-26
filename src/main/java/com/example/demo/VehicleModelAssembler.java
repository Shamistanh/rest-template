package com.example.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
//
@Component
class VehicleModelAssembler implements RepresentationModelAssembler<Vehicle, EntityModel<Vehicle>> {

	@Override
	public EntityModel<Vehicle> toModel(Vehicle car) {

		return EntityModel.of(car, //
				linkTo(methodOn(VehicleController.class).one(car.getId())).withSelfRel(),
				linkTo(methodOn(VehicleController.class).all()).withRel("cars"));
	}

}