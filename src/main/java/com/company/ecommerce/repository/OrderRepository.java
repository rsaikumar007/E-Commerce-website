package com.company.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.company.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
