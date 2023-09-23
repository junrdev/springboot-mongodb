package com.junrdev.datamongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataMongodbApplication {

	private static final Logger logger = LoggerFactory.getLogger(DataMongodbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataMongodbApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(CustomerRepository repository){
		return (args -> {

			repository.deleteAll();//clear collection

			repository.save(new Customer("Brian", "Kidiga"));
			repository.save(new Customer("Brain", "Kidiga"));
			repository.save(new Customer("Barin", "Kidiga"));

			for (Customer c: repository.findByLastName("Kidiga"))
				logger.info(c.toString());

			logger.info("\n\n");

			for (Customer c : repository.findByLastNameIgnoreCase("kIdiGa"))
				logger.info(c.toString());

			logger.info("\n\n");
			logger.info("First Name : "+ repository.findByFirstName("Brian"));
		});
	}
}
