package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    private int id;
    private FullName fullName;
    @OneToOne
    private Address address;
    @OneToOne
    private Account account;
    @OneToMany(mappedBy = "customer")
    private List<Cart> carts;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}