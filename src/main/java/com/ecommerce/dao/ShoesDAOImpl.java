package com.ecommerce.dao;

import com.ecommerce.model.Shoes;
import org.springframework.stereotype.Repository;

@Repository
public class ShoesDAOImpl implements ShoesDAO {
    public Shoes getShoesById(String idShoes) { return null; }
    public void createShoes(Shoes shoes) {}
    public void updateShoes(Shoes shoes) {}
    public void deleteShoes(String idShoes) {}
}