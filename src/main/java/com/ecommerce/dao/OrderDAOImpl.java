package com.ecommerce.dao;

import com.ecommerce.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {
    public Order getOrderById(String idOrder) { return null; }
    public void createOrder(Order order) {}
    public void updateOrder(Order order) {}
    public void deleteOrder(String idOrder) {}
}