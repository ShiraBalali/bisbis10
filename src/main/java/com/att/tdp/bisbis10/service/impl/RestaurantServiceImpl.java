package com.att.tdp.bisbis10.service.impl;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.DishRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepository restaurantRepository;
    DishRepository dishRepository;


    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void updateRestaurant(String id, Restaurant restaurant) {
        Restaurant rest = restaurantRepository.findById(id).get();

        if (restaurant.getName() != null) {
            rest.setName(restaurant.getName());
        }

        if (restaurant.getIsKosher() != null) {
            rest.setIsKosher(restaurant.getIsKosher());
        }
        if (restaurant.getCuisines() != null) {
            rest.setCuisines(restaurant.getCuisines());
        }

        restaurantRepository.save(rest);
    }

    @Override
    public void deleteRestaurant(String id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant getRestaurant(String id) {
        Restaurant rest = restaurantRepository.findById(id).get();

        return rest;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantByCuisine(String cuisine) {
        List<Restaurant> restaurantsByCuisine = restaurantRepository.findAll().stream().filter(restaurant -> restaurant.getCuisines().contains(cuisine)).toList();

        return restaurantsByCuisine;
    }

    @Override
    public void createRestaurantDish(String restaurantId, Dish dish) {
        Restaurant rest = restaurantRepository.findById(restaurantId).get();

        dish.setRestaurant(rest);
        rest.getDishes().add(dish);
        restaurantRepository.save(rest);
    }

    @Override
    public List<Dish> getRestaurantDishes(String restaurantId) {
        Restaurant rest = restaurantRepository.findById(restaurantId).get();

        return rest.getDishes();
    }

    @Override
    public void deleteRestaurantDish(String restaurantId, String dishId) {

        dishRepository.deleteById(dishId);
    }

    @Override
    public void updateRestaurantDish(String dishId, Dish dish) {
        Dish restDish = dishRepository.findById(dishId).get();

        if (dish.getName() != null) {
            restDish.setName(dish.getName());
        }

        if (dish.getDescription() != null) {
            restDish.setDescription(dish.getDescription());
        }

        if(dish.getPrice() != 0){
            restDish.setPrice(dish.getPrice());
        }

        dishRepository.save(restDish);
    }
}
