package com.ecommerce.service;

import com.ecommerce.model.*;
import com.ecommerce.repository.CartDAO;
import com.ecommerce.repository.CustomerDAO;
import com.ecommerce.repository.ItemDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartDAO cartDAO;
    private final CustomerDAO customerDAO;
    private final ItemDAO itemDAO;

    @Override
    public List<Cart> getCartByCustomerId(String customerId) {
        return cartDAO.findByCustomerIdAndOrderIsNull(Integer.parseInt(customerId));
    }

    @Override
    public void createCart(Cart cart) {
        cartDAO.save(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDAO.save(cart);
    }

    @Override
    public void deleteCart(String idCart) {
        cartDAO.deleteById(idCart);
    }

    @Override
    public void checkOutCart(String customerId, String paymentMethod, String shippingMethod) {
        List<Cart> carts = cartDAO.findByCustomerIdAndOrderIsNull(Integer.parseInt(customerId));
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
        });
        cartDAO.saveAll(cartsWithOrder);
    }

    @Override
    public void addItemToCart(String customerId, String itemId) {
        int parsedItemId = Integer.parseInt(itemId); // Convert itemId to int
        Cart cart = new Cart();
        Customer customer = customerDAO.findById(Integer.valueOf(customerId)).get();
        Item item = itemDAO.findById(parsedItemId).get();
        cart.setCustomer(customer);
        cart.setItem(item);
        cartDAO.save(cart);
    }

    @Override
    public void removeItemFromCart(String customerId, String itemId) {
        int parsedItemId = Integer.parseInt(itemId); // Convert itemId to int
        List<Cart> carts = cartDAO.findByCustomerId(Integer.parseInt(customerId));
        carts.stream()
                .filter(cart -> cart.getItem().getId() == parsedItemId) // Compare as int
                .findFirst()
                .ifPresent(cartDAO::delete);
    }

    @Override
    public double calculateTotalPrice(String customerId) {
        return cartDAO.findByCustomerId(Integer.parseInt(customerId)).stream()
                .mapToDouble(cart -> cart.getItem().getPrice())
                .sum();
    }
}