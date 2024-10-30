package com.ecommerce.controller;

import com.ecommerce.model.Item;
import com.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/search")
    public String searchItems(@RequestParam String keyword, Model model) {
        List<Item> items = itemService.searchItems(keyword);
        model.addAttribute("items", items);
        return "search";
    }

    @GetMapping("/{itemId}")
    public String viewItemDetails(@PathVariable String itemId, Model model) {
        Item item = itemService.getItemById(itemId);
        model.addAttribute("item", item);
        return "itemDetails";
    }
}