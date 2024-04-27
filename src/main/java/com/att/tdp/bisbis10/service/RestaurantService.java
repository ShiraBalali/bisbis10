package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public void createRestaurant(Restaurant restaurant);

    public void updateRestaurant(String id, Restaurant restaurant);

    public void deleteRestaurant(String id);

    public Restaurant getRestaurant(String id);

    public List<Restaurant> getAllRestaurants();

    public List<Restaurant> getRestaurantByCuisine(String cuisine);

    public void createRestaurantDish(String restaurantId, Dish dish);

    public List<Dish> getRestaurantDishes(String restaurantId);

    public void deleteRestaurantDish(String restaurantId, String dishId);

    public void updateRestaurantDish(String id, Dish dish);
}
