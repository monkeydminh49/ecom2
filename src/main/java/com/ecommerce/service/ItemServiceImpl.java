package com.ecommerce.service;

import com.ecommerce.model.Item;
import com.ecommerce.repository.ItemDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemDAO itemDAO;

    public List<Item> searchItems(String keyword) {
        return itemDAO.searchItems(keyword);
    }

    public Item getItemById(int itemId) {
        return itemDAO.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
    }
}