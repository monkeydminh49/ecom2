package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ship_by_sea")
public class ShipBySea extends Shipment {

    private String shipName;
    @Id
    private int id;

    public String getShipName() { return shipName; }
    public void setShipName(String shipName) { this.shipName = shipName; }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}