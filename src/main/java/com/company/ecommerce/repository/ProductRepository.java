package com.company.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	Product findProductByProductName(String productName);

}
