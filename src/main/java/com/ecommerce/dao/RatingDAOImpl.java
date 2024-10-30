package com.ecommerce.dao;

import com.ecommerce.model.Rating;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingDAOImpl implements RatingDAO {
    private List<Rating> ratings;

    public Rating getRatingById(int id) { return null; }
    public void addRating(Rating rating) {}
    public void updateRating(Rating rating) {}
    public void deleteRating(int id) {}
}