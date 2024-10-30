package com.ecommerce.dao;

import com.ecommerce.model.Shipment;
import org.springframework.stereotype.Repository;

@Repository
public class ShipmentDAOImpl implements ShipmentDAO {
    public void createShipment(Shipment shipment) {}
    public void updateShipment(Shipment shipment) {}
    public void deleteShipment(int idShipment) {}
    public Shipment getShipmentById(int idShipment) { return null; }
}