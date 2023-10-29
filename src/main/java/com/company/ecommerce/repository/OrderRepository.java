package com.company.ecommerce.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	@Query("SELECT o FROM Order o")
    List<Order> findAllOrders();
	List<Order> findByPaymentStatus(String paymentStatus);
    Order findByTransactionId(String transactionId);

}
