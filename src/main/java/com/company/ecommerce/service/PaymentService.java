package com.company.ecommerce.service;

public interface PaymentService {
	String processUpiPayment(Integer orderId, double amount,String paymentMethod,String upiId);
    String processCodPayment(Integer orderId, double amount,String paymentMethod);
}
