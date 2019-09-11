package com.in.rds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in.common.model.Customer;
import com.in.rds.service.CustomerService;

@RestController
@RequestMapping(value="/services")
public class RentalDataController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value="/customer", method = RequestMethod.POST)
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
}