package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ship_by_drone")
public class ShipByDrone extends Shipment {

    @Id
    private int id;
    private double flightDuration;

    public double getFlightDuration() { return flightDuration; }
    public void setFlightDuration(double flightDuration) { this.flightDuration = flightDuration; }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}