package com.company.ecommerce.service;

import java.util.List;
import com.company.ecommerce.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

    String insertProduct(Product product);

    String updateProduct(Product product);

    Product getProductById(Integer id);

    String deleteProduct(Integer id);

    Product getbyId(Integer id);

    Product getProductByName(String productName);
}