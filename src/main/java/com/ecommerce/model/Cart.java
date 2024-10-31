package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id_cart", columnDefinition = "VARCHAR(50)")
    private String idCart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")     // This column will hold the foreign key to the payment table
    private Payment payment;
}