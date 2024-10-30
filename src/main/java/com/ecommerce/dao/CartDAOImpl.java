package com.ecommerce.dao;

import com.ecommerce.model.Cart;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class CartDAOImpl implements CartDAO {
    public Cart getCartByCustomerId(String idCustomer) { return new Cart(); }
    public void createCart(Cart cart) {}
    public void updateCart(Cart cart) {}
    public void deleteCart(String idCart) {}
}