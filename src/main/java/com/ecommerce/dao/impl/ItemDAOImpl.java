package com.ecommerce.dao.impl;

import com.ecommerce.dao.ItemDAO;
import com.ecommerce.dao.repo.ItemRepository;
import com.ecommerce.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemDAOImpl implements ItemDAO {
    private final ItemRepository itemRepository;

    public List<Item> searchItems(String keyword) {
        return itemRepository.searchItems(keyword);
    }

    public Item getItemById(int itemId) {
        return itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public int checkStockQuantity(int itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        return item.getStockQuantity();
    }

    @Override
    public void updateStockQuantity(int itemId, int quantity) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        int newQuantity = item.getStockQuantity() - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Insufficient stock");
        }
        item.setStockQuantity(newQuantity);
        itemRepository.save(item);
    }
}