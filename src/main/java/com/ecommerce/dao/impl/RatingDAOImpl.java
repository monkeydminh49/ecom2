package com.ecommerce.dao.impl;

import com.ecommerce.dao.RatingDAO;
import com.ecommerce.model.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class RatingDAOImpl implements RatingDAO {
    private final List<Rating> ratings = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Rating getRatingById(int id) {
        return ratings.stream()
                .filter(rating -> rating.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteRatingById(int id) {
        ratings.removeIf(rating -> rating.getId() == id);
    }

    @Override
    public void addRating(Rating rating) {
        rating.setId(random.nextInt(1000)); // Assuming Rating has a setId method
        ratings.add(rating);
    }

    @Override
    public void updateRating(Rating rating) {
        for (int i = 0; i < ratings.size(); i++) {
            if (ratings.get(i).getId() == rating.getId()) {
                ratings.set(i, rating);
                return;
            }
        }
    }

    @Override
    public void deleteRating(Rating rating) {
        ratings.remove(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return new ArrayList<>(ratings);
    }
}