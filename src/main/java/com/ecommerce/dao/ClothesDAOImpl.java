package com.ecommerce.dao;

import com.ecommerce.model.Clothes;
import org.springframework.stereotype.Repository;

@Repository
public class ClothesDAOImpl implements ClothesDAO {
    public Clothes getClothesById(String idClothes) { return null; }
    public void createClothes(Clothes clothes) {}
    public void updateClothes(Clothes clothes) {}
    public void deleteClothes(String idClothes) {}
}