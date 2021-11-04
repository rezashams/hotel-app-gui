/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.bootstrap;

import com.hotel.web.model.User;
import com.hotel.web.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private  final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("reza");
        user.setPassword("123");
        user.setManager(true);
        user.setEmail("rezashams86@gmail.com");
        user.setStudent(false);
        userService.registerUser(user);
        System.out.println("users loaded...");
    }
}
