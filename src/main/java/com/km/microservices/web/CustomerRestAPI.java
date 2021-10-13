package com.km.microservices.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.km.microservices.dto.CustomerRequestDTO;
import com.km.microservices.dto.CustomerResponseDTO;
import com.km.microservices.services.CustomerService;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/customers")
	public List<CustomerResponseDTO> allCustomers() {
		return customerService.listCustomers();
	}

	@PostMapping(path = "/customers")
	public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
		return customerService.save(customerRequestDTO);
	}

	@GetMapping(path = "/customers/{id}")
	public CustomerResponseDTO getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}

	@PutMapping(path = "/customers")
	public CustomerResponseDTO updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
		return customerService.update(customerRequestDTO);
	}

}
