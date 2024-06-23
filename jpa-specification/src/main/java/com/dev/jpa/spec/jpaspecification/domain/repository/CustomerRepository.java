package com.dev.jpa.spec.jpaspecification.domain.repository;

import com.dev.jpa.spec.jpaspecification.domain.entity.Customer;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
}
