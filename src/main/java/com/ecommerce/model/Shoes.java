package com.ecommerce.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SHOES") // Unique value for discriminator column
public class Shoes extends Item {

    private String brand;

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
}