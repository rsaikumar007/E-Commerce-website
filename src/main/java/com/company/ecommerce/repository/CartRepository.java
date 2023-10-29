package com.company.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.ecommerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer>{

	
	@Query("SELECT c FROM Cart c")
    List<Cart> findAllCartItems();
	
    List<Cart> findByOrderPaymentStatus(String paymentStatus);

	

}
