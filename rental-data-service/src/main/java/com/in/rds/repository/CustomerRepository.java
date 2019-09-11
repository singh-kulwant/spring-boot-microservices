package com.in.rds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.common.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
