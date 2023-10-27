package com.company.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ecommerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer>{

}
