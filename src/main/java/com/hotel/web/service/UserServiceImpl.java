/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.service;

import com.hotel.web.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    List<User> users = new ArrayList<>();
    long id=0;
    @Override
    public boolean isRegistered(User user) {
        for(User usr:users)
            if(user.getEmail().equals(usr.getEmail()) && user.getPassword().equals(usr.getPassword()))
                return true;

        return false;
    }

    @Override
    public User registerUser(User user) {
        user.setId(++id);
        users.add(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public User updateUser(User user) {
        for(int i=0;i< users.size();i++) {
            if(users.get(i).getId()==user.getId()) {
                users.remove(i);
                break;
            }
        }
        users.add(user);
        return user;
    }

    @Override
    public User signIn(User user) {
        for(int i=0;i< users.size();i++) {
            if(users.get(i).getEmail().equals(user.getEmail()))
                return users.get(i);
        }
            return null;
    }
}
