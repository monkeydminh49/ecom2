package com.ecommerce.service;

import com.ecommerce.model.Cart;
import com.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getCartByCustomerId(String customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(String idCart) {
        cartRepository.deleteById(idCart);
    }

    @Override
    public void removeItemFromCart(String customerId, String itemId) {
        int parsedItemId = Integer.parseInt(itemId); // Convert itemId to int
        List<Cart> carts = cartRepository.findByCustomerId(customerId);
        carts.stream()
                .filter(cart -> cart.getItem().getId() == parsedItemId) // Compare as int
                .findFirst()
                .ifPresent(cartRepository::delete);
    }

    @Override
    public double calculateTotalPrice(String customerId) {
        return cartRepository.findByCustomerId(customerId).stream()
                .mapToDouble(cart -> cart.getItem().getPrice())
                .sum();
    }
}