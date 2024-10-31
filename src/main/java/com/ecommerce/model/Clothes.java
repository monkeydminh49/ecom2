package com.ecommerce.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CLOTHES") // Unique value for discriminator column
@Getter
@Setter
public class Clothes extends Item {

    private String size;
    private String color;
}