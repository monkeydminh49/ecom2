package com.ecommerce.repository;

import com.ecommerce.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDAO extends JpaRepository<Payment, Integer> {
}
