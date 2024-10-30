package com.ecommerce.dao;

import com.ecommerce.model.Payment;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
    public void createPayment(Payment payment) {}
    public void updatePayment(Payment payment) {}
    public void deletePayment(int idPayment) {}
    public Payment getPaymentById(int idPayment) { return null; }
}