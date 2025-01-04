package com.ecommerce.dao;

import com.ecommerce.model.Item;

import java.util.List;


public interface ItemDAO {
    List<Item> searchItems(String keyword);
    Item getItemById(int itemId);
    int checkStockQuantity(int itemId);
    void updateStockQuantity(int itemId, int quantity);
}