package com.ecommerce.dao;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Payment;

public interface PaymentDAO {
    Payment processPayment(Payment payment);

    Cart getCart(int cartId);
}