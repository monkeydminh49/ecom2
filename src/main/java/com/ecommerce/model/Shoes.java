package com.ecommerce.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("SHOES") // Unique value for discriminator column
@Getter
@Setter
public class Shoes extends Item {

    private String brand;
}