package com.company.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.entity.Customer;
import com.company.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody Customer customer) {
        String message = customerService.insertCustomer(customer);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if (customers.isEmpty()) {
            return new ResponseEntity<>("No Data",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Customer customer) {
        String message = customerService.updateCustomer(customer);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        String message = customerService.deleteCustomer(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
    @GetMapping("/get/{id}")
	public ResponseEntity<Customer> get(@PathVariable("id") Integer id)
	{
		Customer c=customerService.getbyId(id);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
}