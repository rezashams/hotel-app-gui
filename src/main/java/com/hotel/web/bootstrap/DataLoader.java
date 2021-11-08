/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.bootstrap;

import com.hotel.web.model.DateDiscount;
import com.hotel.web.model.Room;
import com.hotel.web.model.User;
import com.hotel.web.service.DiscountService;
import com.hotel.web.service.RoomService;
import com.hotel.web.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DataLoader implements CommandLineRunner {
    private  final UserService userService;
    private  final RoomService roomService;
    private  final DiscountService discountService;

    public DataLoader(UserService userService, RoomService roomService, DiscountService discountService) {
        this.userService = userService;
        this.roomService = roomService;
        this.discountService = discountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("reza");
        user.setLastName("shams");
        user.setPassword("123");
        user.setIsManager(true);
        user.setEmail("rezashams86@gmail.com");
        user.setIsStudent(false);
        userService.registerUser(user);
        Room room = new Room();
        room.setName("room1");
        room.setPrice(12);
        room.setDescription("The Best Room of the World");
        roomService.saveRoom(room);
        Room room2 = new Room();
        room2.setName("room2");
        room2.setPrice(12);
        room2.setDescription("The Best Room of the World");
        roomService.saveRoom(room2);
        Room room3 = new Room();
        room3.setName("room3");
        room3.setPrice(12);
        room3.setDescription("The Best Room of the World");
        roomService.saveRoom(room3);
        DateDiscount dateDiscount = new DateDiscount();
        dateDiscount.setName("Holiday");
        dateDiscount.setPercent(12);
        dateDiscount.setDate(new Date());
        discountService.saveDateDiscount(dateDiscount);
        System.out.println("Data loaded...");
    }
}
