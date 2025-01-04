package com.ecommerce.dao.impl;

import com.ecommerce.dao.ShipmentDAO;
import com.ecommerce.model.Shipment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class ShipmentDAOImpl implements ShipmentDAO {
    private final List<Shipment> shipments = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Shipment saveShipment(Shipment shipment) {
        shipment.setId(random.nextInt(1000)); // Assuming Shipment has a setId method
        shipments.add(shipment);
        return shipment;
    }

    @Override
    public Shipment getShipmentById(int id) {
        return shipments.stream()
                .filter(shipment -> shipment.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteShipment(int id) {
        shipments.removeIf(shipment -> shipment.getId() == id);
    }

    @Override
    public Shipment updateShipment(Shipment shipment) {
        for (int i = 0; i < shipments.size(); i++) {
            if (shipments.get(i).getId() == shipment.getId()) {
                shipments.set(i, shipment);
                return shipment;
            }
        }
        return null;
    }

    @Override
    public List<Shipment> getAllShipments() {
        return new ArrayList<>(shipments);
    }
}