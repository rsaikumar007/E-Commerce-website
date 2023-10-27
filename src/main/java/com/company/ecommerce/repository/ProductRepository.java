package com.company.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	Product findProductByProductName(String productName);
	
	@Query("SELECT p FROM Product p")
    List<Product> findAllProducts();

}
