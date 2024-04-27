package com.att.tdp.bisbis10.controller;


import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ratings")
public class RatingController {
    RatingService ratingService;


    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping
    public void createRating(@RequestBody Rating rating) {
        ratingService.createRating(rating);
    }

    @GetMapping()
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();

    }

}
