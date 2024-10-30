package com.ecommerce.service;

import com.ecommerce.dao.PaymentDAO;
import com.ecommerce.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDAO paymentDAO;

    public Payment processPayment(Payment payment) {
        paymentDAO.createPayment(payment);
        return payment;
    }
}