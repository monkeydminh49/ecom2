package com.ecommerce.dao;

import com.ecommerce.model.Cart;

import java.util.List;

public interface CartDAO {
    List<Cart> getCartByCustomerId(String idCustomer);
    void createCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(String idCart);
}