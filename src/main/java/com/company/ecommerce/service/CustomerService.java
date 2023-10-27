package com.company.ecommerce.service;

import java.util.List;

import com.company.ecommerce.entity.Customer;


public interface CustomerService {

	List<Customer> getAllCustomers();

    String insertCustomer(Customer customer);

    String updateCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    String deleteCustomer(Integer id);
    
    Customer getbyId(Integer id);

    
	}

