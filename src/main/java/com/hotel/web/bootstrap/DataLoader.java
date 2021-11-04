/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.bootstrap;

import com.hotel.web.model.Room;
import com.hotel.web.model.User;
import com.hotel.web.service.RoomService;
import com.hotel.web.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private  final UserService userService;
    private  final RoomService roomService;

    public DataLoader(UserService userService, RoomService roomService) {
        this.userService = userService;
        this.roomService = roomService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("reza");
        user.setLastName("shams");
        user.setPassword("123");
        user.setManager(true);
        user.setEmail("rezashams86@gmail.com");
        user.setStudent(false);
        userService.registerUser(user);
        Room room = new Room();
        room.setName("room1");
        room.setPrice(12);
        room.setDescription("The Best Room of the World");
        roomService.saveRoom(room);
        System.out.println("Data loaded...");
    }
}
