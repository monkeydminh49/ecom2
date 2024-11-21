package com.ecommerce.service;

import com.ecommerce.model.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(int orderId);
    void createOrder(Order order);

    List<Order> getOrderByCustomerId(String customerId);

    List<Order> getOrderByStaffId(String staffId);
}