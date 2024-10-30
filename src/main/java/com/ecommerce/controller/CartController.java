package com.ecommerce.controller;

import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public String viewCart(@PathVariable String customerId, Model model) {
        List<Cart> carts = cartService.getCartByCustomerId(customerId);
        model.addAttribute("carts", carts);
        Double totalPrice = cartService.calculateTotalPrice(customerId);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @PostMapping("/{customerId}/add")
    public String addItemToCart(@PathVariable String customerId, @RequestParam String itemId, Model model) {
        // Logic to add item to cart by customer ID
        return "redirect:/cart/" + customerId;
    }

    @PostMapping("/{customerId}/remove")
    public String removeItemFromCart(@PathVariable String customerId, @RequestParam String itemId) {
        // Logic to remove item from cart by customer ID
        return "redirect:/cart/" + customerId;
    }
}