package com.ecommerce.dao.impl;

import com.ecommerce.model.Order;
import com.ecommerce.dao.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDAOImpl implements OrderRepository.OrderDAO {
    private final OrderRepository orderRepository;

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getOrderByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(Integer.parseInt(customerId));
    }

    @Override
    public List<Order> getOrderByStaffId(String staffId) {
        return orderRepository.findByStaffId(staffId);
    }
}