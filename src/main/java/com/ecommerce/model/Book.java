package com.ecommerce.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("BOOK") // Unique value for discriminator column
public class Book extends Item {

    private String idBook;
    private String title;
    private String ISBN;
    private String author;

    @ManyToOne
    private Category category; // Assuming Category is an entity with @Entity annotation

    private String publisher;
    private String attribute;

    public String getIdBook() { return idBook; }
    public void setIdBook(String idBook) { this.idBook = idBook; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getAttribute() { return attribute; }
    public void setAttribute(String attribute) { this.attribute = attribute; }
}