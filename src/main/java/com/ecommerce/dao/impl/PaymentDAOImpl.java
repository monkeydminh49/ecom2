package com.ecommerce.dao.impl;

import com.ecommerce.dao.PaymentDAO;
import com.ecommerce.dao.repo.CartRepository;
import com.ecommerce.dao.repo.PaymentRepository;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentDAOImpl implements PaymentDAO {
    private final PaymentRepository paymentRepository;
    private final CartRepository cartRepository;

    public Payment processPayment(Payment payment) {
        paymentRepository.save(payment);
        return payment;
    }

    @Override
    public Cart getCart(int cartId) {
        return cartRepository.findById(String.valueOf(cartId)).orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}