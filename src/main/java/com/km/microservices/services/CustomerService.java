package com.km.microservices.services;

import java.util.List;

import com.km.microservices.dto.CustomerRequestDTO;
import com.km.microservices.dto.CustomerResponseDTO;

public interface CustomerService {

	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);

	CustomerResponseDTO getCustomer(String id);

	CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);

	List<CustomerResponseDTO> listCustomers();

}
