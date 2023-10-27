package com.company.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.ecommerce.entity.Order;
import com.company.ecommerce.repository.OrderRepository;
import com.company.ecommerce.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
    	List<Order>list=orderRepository.findAllOrders();
        return list;
    }

    @Override
    public String insertOrder(Order order) {
        orderRepository.save(order);
        return "Order inserted successfully.";
    }

    @Override
    public String updateOrder(Order order) {
        orderRepository.save(order);
        return "Order updated successfully.";
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteOrder(Integer id) {
        orderRepository.deleteById(id);
        return "Order deleted successfully.";
    }
    
    @Override
    public Order getbyId(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

}