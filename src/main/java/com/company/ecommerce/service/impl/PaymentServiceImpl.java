package com.company.ecommerce.service.impl;

import com.company.ecommerce.entity.Order;
import com.company.ecommerce.repository.OrderRepository;
import com.company.ecommerce.service.PaymentService;


import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final OrderRepository orderRepository;

    public PaymentServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String processUpiPayment(Integer orderId, double amount, String paymentMethod, String upiId) {
        // Implementing UPI payment processing 
        if ("upi".equals(paymentMethod)) {
            // Process UPI payment
            Order order = orderRepository.findById(orderId).get();
            if (order != null) {
                String transactionId = generateUniqueTransactionId();
                // Update order details and mark it as paid
                order.setPaymentMethod("UPI");
                order.setPaymentStatus("Paid");
                order.setTransactionId(transactionId);
                orderRepository.save(order);
                return "UPI Payment Successful. Payment status: " + order.getPaymentStatus();
            } else {
                return "UPI Payment Failed. Order not found.";
            }
        } else {
            return "UPI Payment Failed. Invalid payment method.";
        }
    }

    private String generateUniqueTransactionId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String processCodPayment(Integer orderId, double amount, String paymentMethod) {
        // Implementing COD payment processing 
        if ("cod".equals(paymentMethod)) {
            // Process COD payment
            Order order = orderRepository.findById(orderId).get();
            if (order != null) {
                // Update order details and mark it as paid
            	order.setTransactionId("Payment will be COD");
                order.setPaymentMethod("COD");
                order.setPaymentStatus("Paid");
                orderRepository.save(order);
                return "COD Payment Successful. Payment status: " + order.getPaymentStatus();
            } else {
                return "COD Payment Failed. Order not found.";
            }
        } else {
            return "COD Payment Failed. Invalid payment method.";
        }
    }
}
