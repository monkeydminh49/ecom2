package com.ecommerce.dao;

import com.ecommerce.model.Cart;

public interface CartDAO {
    Cart getCartByCustomerId(String idCustomer);
    void createCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(String idCart);
}