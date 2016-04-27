package com.service.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.mvc.model.Customer;
import com.service.mvc.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/example", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping(value = "/get/customer", method = RequestMethod.GET)
    public List<Customer> getCustomer() {
		List<Customer> customer = (List<Customer>) customerService.findAll();
		/*List<Customer> customer = new ArrayList<Customer>();
		customer.add(new Customer(1, "A", "1"));
		customer.add(new Customer(2, "B", "2"));
		customer.add(new Customer(3, "C", "1"));*/
        return customer;
    }
}
