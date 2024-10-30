package com.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public Customer getAuthor() { return author; }
    public void setAuthor(Customer author) { this.author = author; }
}