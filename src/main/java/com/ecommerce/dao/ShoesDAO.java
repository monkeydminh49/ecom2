package com.ecommerce.dao;

import com.ecommerce.model.Shoes;

public interface ShoesDAO {
    Shoes getShoesById(String idShoes);
    void createShoes(Shoes shoes);
    void updateShoes(Shoes shoes);
    void deleteShoes(String idShoes);
}