package com.company.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.ecommerce.entity.Product;
import com.company.ecommerce.repository.ProductRepository;
import com.company.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	 private final ProductRepository productRepository;

	    public ProductServiceImpl(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    @Override
	    public String insertProduct(Product product) {
	        productRepository.save(product);
	        return "Product details inserted successfully.";
	    }

	    @Override
	    public String updateProduct(Product product) {
	        productRepository.save(product);
	        return "Product details updated successfully.";
	    }

	    @Override
	    public Product getProductById(Integer id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    @Override
	    public String deleteProduct(Integer id) {
	        productRepository.deleteById(id);
	        return "Product deleted successfully.";
	    }

	    @Override
	    public Product getbyId(Integer id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Product getProductByName(String productName) {
	        return productRepository.findProductByProductName(productName);
	    }
	}