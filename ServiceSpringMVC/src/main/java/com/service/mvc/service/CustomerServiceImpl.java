package com.service.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.mvc.model.Customer;
import com.service.mvc.repository.CustomerRepository;

@Component
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

}
