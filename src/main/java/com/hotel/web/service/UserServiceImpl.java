/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.service;

import com.hotel.web.model.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    Set<User> users = new HashSet<>();
    @Override
    public boolean isRegistered(User user) {
        for(User usr:users)
            if(user.getEmail().equals(usr.getEmail()) && user.getPassword().equals(usr.getPassword()))
                return true;

        return false;
    }

    @Override
    public User registerUser(User user) {
        users.add(user);
        return user;
    }
}
