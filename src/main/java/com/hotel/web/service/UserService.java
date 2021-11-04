package com.hotel.web.service;

import com.hotel.web.model.User;

public interface UserService {
    boolean isRegistered(User user);
    User registerUser(User user);
}
