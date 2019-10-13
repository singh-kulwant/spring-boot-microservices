package com.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}