package com.ecommerce.controller;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Item;
import com.ecommerce.service.CartService;
import com.ecommerce.service.ItemService;
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

    @Autowired
    private ItemService itemService;

    @GetMapping("/{customerId}")
    public String viewCart(@PathVariable String customerId, Model model) {
        System.out.println("customerId = " + customerId);
        List<Cart> carts = cartService.getCartByCustomerId(customerId);

        // Calculate total price
        double totalPrice = carts.stream()
                .mapToDouble(cart -> cart.getItem().getPrice())
                .sum();

        model.addAttribute("carts", carts);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("customerId", customerId);
        return "cart";
    }

    @PostMapping("/{customerId}/add")
    public String addItemToCart(@PathVariable String customerId, @RequestParam String itemId) {
        Item item = itemService.getItemById(itemId);
        cartService.addItemToCart(customerId, item);
        return "redirect:/cart/" + customerId;
    }

    @PostMapping("/{customerId}/remove")
    public String removeItemFromCart(@PathVariable String customerId, @RequestParam String itemId) {
        Item item = itemService.getItemById(itemId);
        cartService.removeItemFromCart(customerId, item);
        return "redirect:/cart/" + customerId;
    }
}