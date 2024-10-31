package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Use JOINED if each subclass should have its own table
@DiscriminatorColumn(name = "payment_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs
    private int id;

    @Column(name = "payment_type", insertable = false, updatable = false)
    private String paymentType;

    private String method;
    private double amount;

    public static Payment valueOf(String method) {
        if (method.equalsIgnoreCase("paypal")) {
            return new PayByCard();
        } else if (method.equalsIgnoreCase("card")) {
            return new PayByCard();
        } else {
            return new PayByCash();
        }
    }
}