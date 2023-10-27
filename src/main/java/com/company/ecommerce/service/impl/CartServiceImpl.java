package com.company.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.ecommerce.entity.Cart;
import com.company.ecommerce.repository.CartRepository;
import com.company.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> getAllItemsOfCart() {
    	List<Cart>list =cartRepository.findAllCartItems();
        return list;
    }

    @Override
    public String insertOrderItem(Cart cartItem) {
        cartRepository.save(cartItem);
        return "Item Added to Cart";
    }

    @Override
    public String updateOrderItems(Cart cartItem) {
        cartRepository.save(cartItem);
        return "Items Updated in Cart";
    }

    @Override
    public Cart getOrderItemById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteOrderItem(Integer id) {
        cartRepository.deleteById(id);
        return "Item deleted from cart";
    }
}