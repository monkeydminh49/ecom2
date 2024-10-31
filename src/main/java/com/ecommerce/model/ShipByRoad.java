package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ship_by_road")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class ShipByRoad extends Shipment {
    private double deliveryDuration;
}