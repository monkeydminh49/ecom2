package com.ecommerce.service;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAO cartDAO;

    public Cart getCartByCustomerId(String customerId) {
        return cartDAO.getCartByCustomerId(customerId);
    }

    public void addItemToCart(String customerId, Item item) {
        Cart cart = cartDAO.getCartByCustomerId(customerId);
//        cart.addItem(item);
        cartDAO.updateCart(cart);
    }

    public void removeItemFromCart(String customerId, Item item) {
        Cart cart = cartDAO.getCartByCustomerId(customerId);
//        cart.removeItem(item);
        cartDAO.updateCart(cart);
    }

    public double calculateTotalPrice(String customerId) {
        Cart cart = cartDAO.getCartByCustomerId(customerId);
        return cart.getTotalPrice();
    }
}