package com.ecommerce.service;

import com.ecommerce.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {
    List<Item> searchItems(String keyword);
    Item getItemById(String itemId);
}