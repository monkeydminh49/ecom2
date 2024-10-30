package com.ecommerce.service;

import com.ecommerce.model.Order;

public interface OrderService {
    Order getOrderById(String orderId);
    void createOrder(Order order);
}