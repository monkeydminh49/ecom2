package com.ecommerce.controller;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Item;
import com.ecommerce.service.CartService;
import com.ecommerce.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping({"/item/{customerId}", "/{customerId}"})
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;
    private final CartService cartService;

    @GetMapping({"/search", "/"})
    public String searchItems(@RequestParam(required = false) String keyword,
                              Model model,
                              @PathVariable String customerId) {
        if (keyword == null) keyword = "";
        List<Item> items = itemService.searchItems(keyword);
        List<Cart> carts =  cartService.getCartByCustomerId(customerId);
        log.info("Found {} items", items.size());
        model.addAttribute("items", items);
        model.addAttribute("cartCount", carts.size());
        return "search";
    }

    @GetMapping("/detail/{itemId}")
    public String viewItemDetails(@PathVariable int itemId,
                                  Model model,
                                  @PathVariable String customerId) {
        Item item = itemService.getItemById(itemId);
        model.addAttribute("item", item);
        List<Cart> carts =  cartService.getCartByCustomerId(customerId);
        model.addAttribute("cartCount", carts.size());
        return "itemDetail";
    }
}