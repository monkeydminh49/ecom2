package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ratings")
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int ratingValue;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Customer author;

    @ManyToOne
    @JoinColumn(name = "item_id") // This establishes the relationship with Item
    private Item item;
}