package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("BOOK") // Unique value for discriminator column
@Getter
@Setter
public class Book extends Item {

    private String idBook;
    private String title;
    private String ISBN;
    private String author;

    @ManyToOne
    private Category category; // Assuming Category is an entity with @Entity annotation

    private String publisher;
    private String attribute;
}