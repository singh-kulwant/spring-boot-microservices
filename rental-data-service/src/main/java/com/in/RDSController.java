package com.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in.model.Customer;
import com.in.service.CustomerService;

@RestController
@RequestMapping(value = "/rental")
public class RDSController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String test() {
		return "hello";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
}
