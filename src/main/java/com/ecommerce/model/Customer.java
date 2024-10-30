package com.ecommerce.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public FullName getFullName() { return fullName; }
    public void setFullName(FullName fullName) { this.fullName = fullName; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
    public List<Cart> getCarts() { return carts; }
    public void setCart(List<Cart> carts) { this.carts = carts; }
}