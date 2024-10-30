package com.ecommerce.dao;

import com.ecommerce.model.Clothes;

public interface ClothesDAO {
    Clothes getClothesById(String idClothes);
    void createClothes(Clothes clothes);
    void updateClothes(Clothes clothes);
    void deleteClothes(String idClothes);
}