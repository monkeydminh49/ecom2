package com.ecommerce.repository;

import com.ecommerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemDAO extends JpaRepository<Item, Integer> {
    @Query("SELECT i FROM Item i WHERE :keyword = '' OR i.name LIKE %:keyword%")
    List<Item> searchItems(String keyword);
}
