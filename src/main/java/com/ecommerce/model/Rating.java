package com.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
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

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRatingValue() { return ratingValue; }
    public void setRatingValue(int ratingValue) { this.ratingValue = ratingValue; }

    public Customer getAuthor() { return author; }
    public void setAuthor(Customer author) { this.author = author; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
}