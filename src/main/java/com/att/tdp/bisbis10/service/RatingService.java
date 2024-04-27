package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Rating;

import java.util.List;

public interface RatingService {

    public void createRating(Rating rating);

    public List<Rating> getAllRatings();

}
