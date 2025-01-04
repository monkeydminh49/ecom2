package com.ecommerce.dao.impl;

import com.ecommerce.model.Shoes;
import com.ecommerce.dao.repo.ItemRepository;
import com.ecommerce.dao.ShoesDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShoesDAOImpl implements ShoesDAO {

    private final ItemRepository itemRepository;

    @Override
    public Shoes findByShoesId(Long shoesId) {
        var item = itemRepository.findById(Math.toIntExact(shoesId));
        if (item.isPresent()) {
            return (Shoes) item.get();
        }
        return null;
    }

    @Override
    public List<Shoes> getAllShoes() {
        var item = itemRepository.findAll();
        List<Shoes> shoes = new ArrayList<>();
        for (var i : item) {
            shoes.add((Shoes) i);
        }
        return shoes;
    }

    @Override
    public void createShoes(Shoes shoes) {
        var item = itemRepository.save(shoes);
    }

    @Override
    public void updateShoes(Shoes shoes) {
        var item = itemRepository.save(shoes);
    }


}