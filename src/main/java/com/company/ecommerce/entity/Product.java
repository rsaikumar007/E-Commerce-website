package com.company.ecommerce.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private Integer productId;
    private String productName;
    private String description;
    private Double productPrice;

    @OneToMany(mappedBy = "product")
    private List<Cart> cartItems;

}
