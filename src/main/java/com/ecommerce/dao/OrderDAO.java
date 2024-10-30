package com.ecommerce.dao;

import com.ecommerce.model.Order;

public interface OrderDAO {
    Order getOrderById(String idOrder);
    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(String idOrder);
}