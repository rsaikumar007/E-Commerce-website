package com.company.ecommerce.service;

import java.util.List;

import com.company.ecommerce.entity.Cart;

public interface CartService {

	List<Cart> getAllItemsOfCart();

    String insertOrderItem(Cart cartItem);

    String updateOrderItems(Cart cartItem);

    Cart getOrderItemById(Integer id);

    String deleteOrderItem(Integer id);
    
}