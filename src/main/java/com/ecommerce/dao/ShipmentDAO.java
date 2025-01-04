package com.ecommerce.dao;

import com.ecommerce.model.Shipment;

import java.util.List;

public interface ShipmentDAO {
    Shipment saveShipment(Shipment shipment);

    Shipment getShipmentById(int id);

    void deleteShipment(int id);

    Shipment updateShipment(Shipment shipment);

    List<Shipment> getAllShipments();

}
