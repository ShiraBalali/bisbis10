package com.att.tdp.bisbis10.service.impl;

import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.RatingRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import com.att.tdp.bisbis10.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;
    RestaurantRepository restaurantRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, RestaurantRepository restaurantRepository) {
        this.ratingRepository = ratingRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void createRating(Rating rating) {
        Restaurant rest = restaurantRepository.findById(rating.getRestaurantId().toString()).get();
        long restaurantRatingCount = ratingRepository.findAll().stream().filter(r -> rating.getRestaurantId() == r.getRestaurantId()).count();

        float newAverage = ((restaurantRatingCount * rest.getAverageRating()) + rating.getRating()) / (restaurantRatingCount + 1);
        rest.setAverageRating(newAverage);
        restaurantRepository.save(rest);
        ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

}
