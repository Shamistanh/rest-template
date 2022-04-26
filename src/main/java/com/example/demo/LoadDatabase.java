package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(VehiclesRepository repository) {

		return args -> {
			log.info("Loading " + repository.save(new Vehicle("Reanult-Capture", "2019", "SUV","Automatic","Hybrid")));
			log.info("Loading " + repository.save(new Vehicle("Peugeot-308", "2020", "Car","Manual","Gasoline")));
			log.info("Loading " + repository.save(new Vehicle("Ford-Focus", "2015", "Car","Manual","Gasoline")));
			log.info("Loading " + repository.save(new Vehicle("Renault-Clio", "2021", "Car","Manual","Gasoline")));
			log.info("Loading " + repository.save(new Vehicle("MercedesBenz-EQC", "2019", "SUV","Automatic","Hybrid")));
		};
	}
}