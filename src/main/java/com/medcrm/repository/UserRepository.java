package com.medcrm.repository;

import com.medcrm.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<String, User> userMap = new HashMap<>();

    // Add user to repository
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    // Delete user by ID
    public boolean deleteUserById(String id) {
        return userMap.remove(id) != null;
    }

    // Find user by ID
    public User findUserById(String id) {
        return userMap.get(id);
    }

    // Find user by email (e.g., for login)
    public User findUserByEmail(String email) {
        for (User user : userMap.values()) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    // Get all users (optional)
    public Map<String, User> getAllUsers() {
        return userMap;
    }
}
