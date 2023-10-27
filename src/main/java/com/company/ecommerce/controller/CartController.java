package com.company.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.entity.Cart;
import com.company.ecommerce.service.CartService;
import com.company.ecommerce.service.OrderService;
import com.company.ecommerce.service.ProductService;

@RestController
@RequestMapping("/cart")
public class CartController {

	
	private final CartService cartService;
    private final OrderService orderService;
    private final ProductService productService;

    public CartController(CartService cartService, OrderService orderService, ProductService productService) {
        this.cartService = cartService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Cart>> getAllCartItems() {
        List<Cart> cartItems = cartService.getAllItemsOfCart();
        if (cartItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @PostMapping("/insert/{orderId}/{productId}")
    public ResponseEntity<String> insert(@PathVariable Integer orderId, @PathVariable Integer productId, @RequestBody Cart cartItem) {
        com.company.ecommerce.entity.Order order = orderService.getbyId(orderId);
        order.setOrderId(orderId);
        com.company.ecommerce.entity.Product product = productService.getbyId(productId);
        product.setProductId(productId);
        String message = cartService.insertOrderItem(cartItem);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Cart cartItem) {
        String message = cartService.updateOrderItems(cartItem);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        String message = cartService.deleteOrderItem(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}