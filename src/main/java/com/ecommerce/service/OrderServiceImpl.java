package com.ecommerce.service;

import com.ecommerce.dao.OrderDAO;
import com.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    public Order getOrderById(String orderId) {
        return orderDAO.getOrderById(orderId);
    }

    public void createOrder(Order order) {
        orderDAO.createOrder(order);
    }
}