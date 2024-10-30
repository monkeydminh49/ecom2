package com.ecommerce.service;

import com.ecommerce.model.Payment;

public interface PaymentService {
    Payment processPayment(Payment payment);
}