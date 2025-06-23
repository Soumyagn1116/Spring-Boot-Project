package com.app.fooddelivery.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "restaurant")
    private List<FoodItem> menu;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Restaurant() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    public void setMenu(List<FoodItem> menu) {
        this.menu = menu;
    }
}
