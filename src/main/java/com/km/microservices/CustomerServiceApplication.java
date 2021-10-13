package com.km.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.km.microservices.dto.CustomerRequestDTO;
import com.km.microservices.services.CustomerService;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService) {
		return args -> {
			customerService.save(new CustomerRequestDTO("CO1", "customer1", "customer1@gmail.com"));
			customerService.save(new CustomerRequestDTO("CO2", "customer2", "customer2@gmail.com"));

		};
	}

}
