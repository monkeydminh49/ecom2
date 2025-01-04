package com.ecommerce.dao.impl;

import com.ecommerce.dao.*;
import com.ecommerce.dao.repo.CartRepository;
import com.ecommerce.dao.repo.CustomerRepository;
import com.ecommerce.dao.repo.ItemRepository;
import com.ecommerce.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartDAOImpl implements CartDAO {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    @Override
    public List<Cart> getCartByCustomerId(String customerId) {
        return cartRepository.findByCustomerIdAndOrderIsNull(Integer.parseInt(customerId));
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
    public void checkOutCart(String customerId, String paymentMethod, String shippingMethod) {
        List<Cart> carts = cartRepository.findByCustomerIdAndOrderIsNull(Integer.parseInt(customerId));
        List<Cart> cartsWithOrder = new ArrayList<>(carts);
        carts.forEach(cart -> {
            Order order = new Order();
            order.setCustomer(cart.getCustomer());
            order.setStatus("Pending");
            Payment payment = Payment.valueOf(paymentMethod);
            order.setPayment(payment);
            Shipment shipping = Shipment.valueOf(shippingMethod);
            order.setShipment(shipping);
            order.setCart(cart);
            cart.setOrder(order);
            cartsWithOrder.add(cart);

            // Update stock quantity
            Item item = cart.getItem();
            int newQuantity = item.getStockQuantity() - 1;
            if (newQuantity < 0) {
                throw new RuntimeException("Insufficient stock for item: " + item.getName());
            }
            item.setStockQuantity(newQuantity);
            itemRepository.save(item);
        });
        cartRepository.saveAll(cartsWithOrder);
    }

    @Override
    public void addItemToCart(String customerId, String itemId) {
        int parsedItemId = Integer.parseInt(itemId); // Convert itemId to int
        int parsedCustomerId = Integer.parseInt(customerId); // Convert customerId to int

        // Check if the cart entry already exists
        List<Cart> existingCarts = cartRepository.findByCustomerIdAndItemIdAndOrderIsNull(parsedCustomerId, parsedItemId);
        if (!existingCarts.isEmpty()) {
            // Update the quantity of the existing cart entry
            Cart existingCart = existingCarts.get(0);
            existingCart.setQuantity(existingCart.getQuantity() + 1);
            cartRepository.save(existingCart);
        } else {
            // Create a new cart entry
            Cart cart = new Cart();
            Customer customer = customerRepository.findById(parsedCustomerId).get();
            Item item = itemRepository.findById(parsedItemId).get();
            cart.setCustomer(customer);
            cart.setItem(item);
            cart.setQuantity(1); // Set initial quantity to 1
            cartRepository.save(cart);
        }
    }

    @Override
    public void removeItemFromCart(String customerId, String itemId) {
        int parsedItemId = Integer.parseInt(itemId); // Convert itemId to int
        List<Cart> carts = cartRepository.findByCustomerId(Integer.parseInt(customerId));
        carts.stream()
                .filter(cart -> cart.getItem().getId() == parsedItemId) // Compare as int
                .findFirst()
                .ifPresent(cartRepository::delete);
    }

    @Override
    public double calculateTotalPrice(String customerId) {
        return cartRepository.findByCustomerId(Integer.parseInt(customerId)).stream()
                .mapToDouble(cart -> cart.getItem().getPrice())
                .sum();
    }


}