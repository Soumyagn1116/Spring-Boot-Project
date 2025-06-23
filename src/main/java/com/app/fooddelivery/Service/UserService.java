package com.app.fooddelivery.Service;

import com.app.fooddelivery.Entity.User;
import com.app.fooddelivery.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ by ID
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // READ ALL
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // UPDATE
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUser(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // ✅ Login/Signup Support
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
