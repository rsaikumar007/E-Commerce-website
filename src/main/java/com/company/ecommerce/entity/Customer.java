package com.company.ecommerce.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    private Integer customerId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String address;
    /*
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
*/

}
