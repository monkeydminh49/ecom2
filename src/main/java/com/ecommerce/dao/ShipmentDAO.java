package com.ecommerce.dao;

import com.ecommerce.model.Shipment;

public interface ShipmentDAO {
    void createShipment(Shipment shipment);
    void updateShipment(Shipment shipment);
    void deleteShipment(int idShipment);
    Shipment getShipmentById(int idShipment);
}