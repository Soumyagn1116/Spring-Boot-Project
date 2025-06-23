package com.app.fooddelivery.Repository;

import com.app.fooddelivery.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @org.springframework.data.jpa.repository.Query("SELECT r FROM Restaurant r WHERE r.name = :name")
    Restaurant findByName(@org.springframework.data.repository.query.Param("name") String name);
}
