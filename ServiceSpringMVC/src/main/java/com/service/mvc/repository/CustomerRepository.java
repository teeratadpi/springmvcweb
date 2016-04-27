package com.service.mvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.service.mvc.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	//public List<Customer> findAll();
}
