package com.ecommerce.dao;

import com.ecommerce.model.Item;
import java.util.List;

public interface ItemDAO {
    Item getItemById(String idItem);
    void createItem(Item item);
    void updateItem(Item item);
    void deleteItem(String idItem);
    List<Item> search(String keyword); // Added search method
}