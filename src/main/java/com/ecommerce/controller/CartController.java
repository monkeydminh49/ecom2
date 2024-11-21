package com.ecommerce.controller;

import com.ecommerce.dto.OrderData;
import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public String viewCart(@PathVariable String customerId, Model model) {
        List<Cart> carts = cartService.getCartByCustomerId(customerId);
        log.info("Cart amount item for customer: {}, is: {}", customerId, carts.size());
        model.addAttribute("carts", carts);
        Double totalPrice = cartService.calculateTotalPrice(customerId);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("customerId", customerId);
        return "cart";
    }

    @PostMapping("/{customerId}/add")
    public String addItemToCart(@PathVariable String customerId, @RequestParam String itemId, Model model) {
        cartService.addItemToCart(customerId, itemId);
        return "redirect:/cart/" + customerId;
    }

    @PostMapping("/{customerId}/remove")
    public String removeItemFromCart(@PathVariable String customerId, @RequestParam String itemId) {
        cartService.removeItemFromCart(customerId, itemId);
        return "redirect:/cart/" + customerId;
    }

    @PostMapping("/checkout/{customerId}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> checkout(@PathVariable String customerId, @RequestBody OrderData orderData) {
        log.info("Order submitted successfully for customer: {}, paymentMethod: {}, shippingMethod: {}", customerId, orderData.getPaymentMethod(), orderData.getShippingMethod());
        cartService.checkOutCart(customerId, orderData.getPaymentMethod(), orderData.getShippingMethod());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Order submitted successfully");
        response.put("customerId", customerId);
        response.put("paymentMethod", orderData.getPaymentMethod());
        response.put("shippingMethod", orderData.getShippingMethod());

        return ResponseEntity.ok(response);
    }
}