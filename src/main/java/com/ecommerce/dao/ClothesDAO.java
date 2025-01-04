package com.ecommerce.dao;

import com.ecommerce.model.Clothes;

import java.util.List;

public interface ClothesDAO {
    void createClothes();
    void updateClothes();
    void deleteClothes();
    Clothes getClothes();

    List<Clothes> getAllClothes();
}
