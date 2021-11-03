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
    public boolean isAuthenticated(String email, String password) {
        for(User usr:users)
            if(email.equals(usr.getEmail()) && password.equals(usr.getPassword()))
                return true;

        return false;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
