package com.km.microservices.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.km.microservices.dto.CustomerRequestDTO;
import com.km.microservices.dto.CustomerResponseDTO;
import com.km.microservices.entities.Customer;
import com.km.microservices.mappers.CustomerMapper;
import com.km.microservices.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	private CustomerMapper customerMapper;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		if (customerRequestDTO.getId() == null)
			customerRequestDTO.setId(UUID.randomUUID().toString());
		Customer customer = customerMapper.cutomerRequestDtoToCustomer(customerRequestDTO);

		Customer savedCustomer = customerRepository.save(customer);

		return customerMapper.cutomerToCustomerDTO(savedCustomer);
	}

	@Override
	public CustomerResponseDTO getCustomer(String id) {
		Customer customer = customerRepository.findById(id).get();
		return customerMapper.cutomerToCustomerDTO(customer);
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
		Customer customer = customerMapper.cutomerRequestDtoToCustomer(customerRequestDTO);

		Customer updatedCustomer = customerRepository.saveAndFlush(customer);

		return customerMapper.cutomerToCustomerDTO(updatedCustomer);
	}

	@Override
	public List<CustomerResponseDTO> listCustomers() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOs = customers.stream()
				.map(cust -> customerMapper.cutomerToCustomerDTO(cust)).collect(Collectors.toList());
		return customerResponseDTOs;
	}

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}

	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

}
