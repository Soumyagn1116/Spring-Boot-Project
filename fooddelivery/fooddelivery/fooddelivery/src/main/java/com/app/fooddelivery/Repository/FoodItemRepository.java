package com.app.fooddelivery.Repository;

import com.app.fooddelivery.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    @Query("SELECT f FROM FoodItem f WHERE f.restaurant.id = :restaurantId")
    List<FoodItem> findByRestaurantId(@Param("restaurantId") Long restaurantId);
}
