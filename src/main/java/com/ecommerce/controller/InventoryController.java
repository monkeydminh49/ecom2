package com.ecommerce.controller;

import com.ecommerce.model.Item;
import com.ecommerce.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/staff/{staffId}"})
public class InventoryController {
    @Autowired
    private ItemDAO itemDAO;

    @GetMapping("/inventory")
    public String showInventory(Model model) {
        List<Item> items = itemDAO.searchItems("");
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/inventory/add")
    @ResponseBody
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        // Add item logic
        return ResponseEntity.ok().build();
    }

    @PutMapping("/inventory/{id}")
    @ResponseBody
    public ResponseEntity<?> updateItem(@PathVariable int id, @RequestBody Item item) {
        // Update item logic
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/inventory/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        // Delete item logic
        return ResponseEntity.ok().build();
    }
}