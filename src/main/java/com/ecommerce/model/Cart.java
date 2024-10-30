package com.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    private String idCart;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToOne(cascade = CascadeType.ALL) // Assuming one payment per cart, and cascading changes
    @JoinColumn(name = "payment_id")     // This column will hold the foreign key to the payment table
    private Payment payment;

    public String getIdCart() { return idCart; }
    public void setIdCart(String idCart) { this.idCart = idCart; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public double getTotalPrice() { return item.getPrice(); }
}