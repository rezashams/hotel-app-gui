package com.hotel.web.service;

import com.hotel.web.model.User;

public interface UserService {
    boolean isRegistered(User user);
    User registerUser(User user);

    void deleteUser(User user);

    User updateUser(User user);


    User signIn(User user);
}
