package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "item_id") // Ensure this column is correctly set up to link to Item
    private Item item;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer author;
}