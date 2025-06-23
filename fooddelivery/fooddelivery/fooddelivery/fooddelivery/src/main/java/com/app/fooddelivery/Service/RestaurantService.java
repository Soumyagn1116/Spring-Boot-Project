package com.app.fooddelivery.Service;

import com.app.fooddelivery.Entity.Restaurant;
import com.app.fooddelivery.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Restaurant existing = getRestaurant(id);
        existing.setName(updatedRestaurant.getName());
        existing.setLocation(updatedRestaurant.getLocation());
        existing.setMenu(updatedRestaurant.getMenu());
        return restaurantRepository.save(existing);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
