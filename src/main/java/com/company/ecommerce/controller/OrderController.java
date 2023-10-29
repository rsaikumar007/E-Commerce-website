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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.entity.Customer;
import com.company.ecommerce.entity.Order;
import com.company.ecommerce.exception.CodPaymentException;
import com.company.ecommerce.exception.UpiPaymentException;
import com.company.ecommerce.service.CustomerService;
import com.company.ecommerce.service.OrderService;
import com.company.ecommerce.service.PaymentService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    

    public OrderController(OrderService orderService, CustomerService customerService,PaymentService paymentService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.paymentService = paymentService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/insert/{customerId}")
    public ResponseEntity<String> insert(@PathVariable Integer customerId, @RequestBody Order order) {
        Customer customer = customerService.getbyId(customerId);
        if (customer != null) {
            order.setCustomer(customer);
            String message = orderService.insertOrder(order);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Order order) {
        String message = orderService.updateOrder(order);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        String message = orderService.deleteOrder(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
    @PostMapping("/UpiPayment")
    public ResponseEntity<String> processUpiPayment(
            @RequestParam Integer orderId,
            @RequestParam double amount,
            @RequestParam String upiId
         ) {
        try {
            String paymentResult = paymentService.processUpiPayment(orderId, amount, "upi", upiId);
            if (paymentResult.contains("Successful")) {
                return ResponseEntity.ok(paymentResult);
            } else {
                return ResponseEntity.status(400).body(paymentResult);
            }
        } catch (UpiPaymentException e) {
            return ResponseEntity.status(400).body("UPI Payment Error: " + e.getMessage());
        }  catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @PostMapping("/CodPayment")
    public ResponseEntity<String> processCodPayment(
            @RequestParam Integer orderId,
            @RequestParam double amount
            
            ) {
        try {
            String paymentResult = paymentService.processCodPayment(orderId, amount, "cod");
            if (paymentResult.contains("Successful")) {
                return ResponseEntity.ok(paymentResult);
            } else {
                return ResponseEntity.status(400).body(paymentResult);
            }
        }  catch (CodPaymentException e) {
            return ResponseEntity.status(400).body("COD Payment Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
