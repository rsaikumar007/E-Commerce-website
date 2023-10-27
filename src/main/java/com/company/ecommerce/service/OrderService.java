package com.company.ecommerce.service;

import java.util.List;

import com.company.ecommerce.entity.Order;

public interface OrderService {

	List<Order> getAllOrders();

    String insertOrder(Order order);

    String updateOrder(Order order);

    Order getOrderById(Integer id);

    String deleteOrder(Integer id);
    
    Order getbyId(Integer id);

}
