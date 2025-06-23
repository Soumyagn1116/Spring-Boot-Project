package com.app.fooddelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = "com.app.fooddelivery")
@EntityScan("com.app.fooddelivery.Entity")
@EnableJpaRepositories("com.app.fooddelivery.Repository")
public class FooddeliveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(FooddeliveryApplication.class, args);
    }
}




