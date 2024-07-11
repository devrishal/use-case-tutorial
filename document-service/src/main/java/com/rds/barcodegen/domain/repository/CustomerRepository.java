package com.rds.barcodegen.domain.repository;

import com.rds.barcodegen.domain.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
