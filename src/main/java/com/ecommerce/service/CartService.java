package com.ecommerce.service;

import com.ecommerce.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartByCustomerId(String customerId);
    void createCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(String idCart);
    void removeItemFromCart(String customerId, String itemId); // Add this method to handle removal
    double calculateTotalPrice(String customerId); // Method to calculate total price
}