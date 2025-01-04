package com.ecommerce.dao.impl;

import com.ecommerce.dao.ClothesDAO;
import com.ecommerce.model.Clothes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClothesDAOImpl implements ClothesDAO {

    private final List<Clothes> clothesList = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void createClothes() {
        Clothes clothes = new Clothes();
        clothes.setName("Clothes" + random.nextInt(100));
        clothes.setSize("Size" + random.nextInt(5));
        clothes.setColor("Color" + random.nextInt(10));
        clothesList.add(clothes);
    }

    @Override
    public void updateClothes() {
        if (!clothesList.isEmpty()) {
            Clothes clothes = clothesList.get(random.nextInt(clothesList.size()));
            clothes.setName("UpdatedClothes" + random.nextInt(100));
            clothes.setSize("UpdatedSize" + random.nextInt(5));
            clothes.setColor("UpdatedColor" + random.nextInt(10));
        }
    }

    @Override
    public void deleteClothes() {
        if (!clothesList.isEmpty()) {
            clothesList.remove(random.nextInt(clothesList.size()));
        }
    }

    @Override
    public Clothes getClothes() {
        if (clothesList.isEmpty()) {
            return null;
        }
        return clothesList.get(random.nextInt(clothesList.size()));
    }

    @Override
    public List<Clothes> getAllClothes() {
        return new ArrayList<>(clothesList);
    }
}