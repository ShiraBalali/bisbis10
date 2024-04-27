package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    public void createRestaurant(Restaurant restaurant);
    public void updateRestaurant(String id, Restaurant restaurant);
    public void deleteRestaurant(String id);
    public Map getRestaurant(String id);
    public List<Restaurant> getAllRestaurants();
    public List<Restaurant> getRestaurantByCuisine(String cuisine);
}
