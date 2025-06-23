package com.app.fooddelivery.Service;

import com.app.fooddelivery.Entity.Order;
import com.app.fooddelivery.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order existing = getOrder(id);
        existing.setUser(updatedOrder.getUser());
        existing.setItems(updatedOrder.getItems());
        existing.setTotalPrice(updatedOrder.getTotalPrice());
        existing.setOrderTime(updatedOrder.getOrderTime());
        return orderRepository.save(existing);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
