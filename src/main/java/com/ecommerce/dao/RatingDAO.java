package com.ecommerce.dao;

import com.ecommerce.model.Rating;

public interface RatingDAO {
    Rating getRatingById(int id);
    void addRating(Rating rating);
    void updateRating(Rating rating);
    void deleteRating(int id);
}