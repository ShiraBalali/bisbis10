package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("{id}")
    public Restaurant getRestaurantDetails(@PathVariable("id") String id) {
        return restaurantService.getRestaurant(id);
    }


    @GetMapping()
    public List<Restaurant> getAllRestaurants(@RequestParam(value = "cuisine", required = false) String cuisine) {
        if (cuisine != null) {
            return restaurantService.getRestaurantByCuisine(cuisine);
        } else {
            return restaurantService.getAllRestaurants();
        }
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("{id}/dishes")
    public void createRestaurantDish(@PathVariable("id") String restaurantId, @RequestBody Dish dish) {
        restaurantService.createRestaurantDish(restaurantId, dish);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("{id}/dishes")
    public List<Dish> GetRestaurantDish(@PathVariable("id") String restaurantId) {
        List<Dish> dishes = restaurantService.getRestaurantDishes(restaurantId);

        return dishes;
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}/dishes/{dishId}")
    public void DeleteRestaurantDish(@PathVariable("id") String restaurantId, @PathVariable("dishId") String dishId) {
        restaurantService.deleteRestaurantDish(restaurantId, dishId);
    }

    @PutMapping("{id}")
    public void updateRestaurantDetails(@PathVariable("id") String id, @RequestBody Restaurant restaurant) {
        restaurantService.updateRestaurant(id, restaurant);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable("id") String id) {
        restaurantService.deleteRestaurant(id);
    }

    @PutMapping("{id}/dishes/{dishId}")
    public void updateRestaurantDish(@PathVariable("dishId") String dishId, @RequestBody Dish restDish) {
        restaurantService.updateRestaurantDish(dishId, restDish);
    }
}
