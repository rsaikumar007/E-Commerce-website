package com.company.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.ecommerce.entity.Customer;
import com.company.ecommerce.repository.CustomerRepository;
import com.company.ecommerce.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
    	List<Customer> list=customerRepository.findAll();
    	return list;
        
    }

    @Override
    public String insertCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer details inserted successfully.";
    }

    @Override
    public String updateCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer details updated successfully.";
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "Customer deleted successfully.";
    }
    
    @Override
    public Customer getbyId(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

}