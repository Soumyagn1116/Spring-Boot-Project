package com.app.fooddelivery.Controller;

import com.app.fooddelivery.Entity.Order;
import com.app.fooddelivery.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderRepository.findById(id).map(order -> {
            order.setOrderTime(orderDetails.getOrderTime());
            order.setTotalPrice(orderDetails.getTotalPrice());
            order.setUser(orderDetails.getUser());
            order.setItems(orderDetails.getItems());
            return ResponseEntity.ok(orderRepository.save(order));
        }).orElse(ResponseEntity.notFound().build());
    }

@DeleteMapping("/{id}")
public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
    return orderRepository.findById(id).map(user -> {
        orderRepository.delete(user);
        return ResponseEntity.noContent().build(); // 
    }).orElse(ResponseEntity.notFound().build());
}

}
