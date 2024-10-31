package com.ecommerce.service;

import com.ecommerce.model.Payment;
import com.ecommerce.repository.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDAO;

    public Payment processPayment(Payment payment) {
        paymentDAO.save(payment);
        return payment;
    }
}