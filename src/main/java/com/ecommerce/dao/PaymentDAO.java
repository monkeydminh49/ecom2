package com.ecommerce.dao;

import com.ecommerce.model.Payment;

public interface PaymentDAO {
    void createPayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(int idPayment);
    Payment getPaymentById(int idPayment);
}