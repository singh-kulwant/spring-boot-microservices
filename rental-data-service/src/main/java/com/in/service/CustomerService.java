package com.in.service;

import java.util.List;

import com.in.model.Customer;

public interface CustomerService {

	Customer save(Customer customer);
	
	List<Customer> findAll();
}
