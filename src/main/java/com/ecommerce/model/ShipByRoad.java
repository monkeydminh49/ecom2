package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ship_by_road")
public class ShipByRoad extends Shipment {
    @Id
    private int id;
    private double deliveryDuration;


    public double getDeliveryDuration() { return deliveryDuration; }
    public void setDeliveryDuration(double deliveryDuration) { this.deliveryDuration = deliveryDuration; }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}