package com.ecommerce.service;

import com.ecommerce.dao.ItemDAO;
import com.ecommerce.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDAO itemDAO;

    public List<Item> searchItems(String keyword) {
        return itemDAO.search(keyword);
    }

    public Item getItemById(String itemId) {
        return itemDAO.getItemById(itemId);
    }
}