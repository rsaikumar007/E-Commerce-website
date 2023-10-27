package com.company.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
