package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface VehiclesRepository extends JpaRepository<Vehicle, Long> {

}