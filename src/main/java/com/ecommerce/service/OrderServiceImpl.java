package com.ecommerce.service;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    public Order getOrderById(int orderId) {
        return orderDAO.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void createOrder(Order order) {
        orderDAO.save(order);
    }

    public List<Order> getOrderByCustomerId(String customerId) {
        return orderDAO.findByCustomerId(Integer.parseInt(customerId));
    }
}