package com.ecommerce.dao;

import com.ecommerce.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDAOImpl implements ItemDAO {
    public Item getItemById(String idItem) { return null; }
    public void createItem(Item item) {}
    public void updateItem(Item item) {}
    public void deleteItem(String idItem) {}
    public List<Item> search(String keyword) {
        // Dummy implementation for search functionality
        return new ArrayList<>(); // Return an empty list or sample items
    }
}