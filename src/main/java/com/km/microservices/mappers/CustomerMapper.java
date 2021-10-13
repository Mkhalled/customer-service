package com.km.microservices.mappers;

import org.mapstruct.Mapper;

import com.km.microservices.dto.CustomerRequestDTO;
import com.km.microservices.dto.CustomerResponseDTO;
import com.km.microservices.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	CustomerResponseDTO cutomerToCustomerDTO(Customer customer);

	Customer cutomerRequestDtoToCustomer(CustomerRequestDTO customer);
}
