package com.att.tdp.bisbis10.service.impl;

import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
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
    public Map getRestaurant(String id) {
        Restaurant rest = restaurantRepository.findById(id).get();

        // TODO: averageRating
        // TODO: dishes

        Map result = new HashMap();
        result.put("id", rest.getId());
        result.put("name", rest.getName());
        result.put("isKosher", rest.getIsKosher());
        result.put("cuisines", rest.getCuisines());

        return result;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        // TODO: same as getRestaurant
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantByCuisine(String cuisine) {
        List<Restaurant> restaurantsByCuisine = restaurantRepository.findAll().stream().filter(restaurant -> restaurant.getCuisines().contains(cuisine)).toList();

        return restaurantsByCuisine;
    }
}
