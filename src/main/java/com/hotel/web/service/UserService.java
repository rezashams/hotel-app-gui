package com.hotel.web.service;

import com.hotel.web.model.User;

public interface UserService {
    boolean isAuthenticated(String username, String password);
    void addUser(User user);
}
