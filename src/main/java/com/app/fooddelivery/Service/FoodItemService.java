package com.app.fooddelivery.Service;

import com.app.fooddelivery.Entity.FoodItem;
import com.app.fooddelivery.Repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public FoodItem getFoodItem(Long id) {
        return foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found"));
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem updateFoodItem(Long id, FoodItem updatedFoodItem) {
        FoodItem existing = getFoodItem(id);
        existing.setName(updatedFoodItem.getName());
        existing.setPrice(updatedFoodItem.getPrice());
        existing.setRestaurant(updatedFoodItem.getRestaurant());
        return foodItemRepository.save(existing);
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}
