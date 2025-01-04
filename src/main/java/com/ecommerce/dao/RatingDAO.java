package com.ecommerce.dao;

import com.ecommerce.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingDAO  {
    Rating getRatingById(int id);

    void deleteRatingById(int id);

    void addRating(Rating rating);

    void updateRating(Rating rating);

    void deleteRating(Rating rating);

    List<Rating> getAllRatings();
}
