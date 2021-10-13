package com.km.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.km.microservices.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
