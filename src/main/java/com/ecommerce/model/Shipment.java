package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shipments")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String trackingNumber;
    private String carrier;
    private String status;
    private String address;

    public static Shipment valueOf(String method) {
        if (method.equalsIgnoreCase("drone")) {
            return new ShipByDrone();
        } else if (method.equalsIgnoreCase("road")) {
            return new ShipByRoad();
        } else {
            return new ShipBySea();
        }
    }
}