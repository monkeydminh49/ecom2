package com.ecommerce.service;

import com.ecommerce.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartByCustomerId(String customerId);
    void createCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(String idCart);

    void checkOutCart(String customerId, String paymentMethod, String shippingMethod); // Add this method to handle checkout

    void addItemToCart(String customerId, String itemId); // Add this method to handle addition
    void removeItemFromCart(String customerId, String itemId); // Add this method to handle removal
    double calculateTotalPrice(String customerId); // Method to calculate total price
}