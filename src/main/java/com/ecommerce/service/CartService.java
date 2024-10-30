package com.ecommerce.service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Item;
import org.springframework.stereotype.Service;


public interface CartService {
    Cart getCartByCustomerId(String customerId);
    void addItemToCart(String customerId, Item item);
    void removeItemFromCart(String customerId, Item item);
    double calculateTotalPrice(String customerId);
}