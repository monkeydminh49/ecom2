package com.ecommerce.dao;

import com.ecommerce.model.Shoes;

import java.util.List;

public interface ShoesDAO {
    Shoes findByShoesId(Long shoesId);

    List<Shoes> getAllShoes();

    void createShoes(Shoes shoes);

    void updateShoes(Shoes shoes);
}
