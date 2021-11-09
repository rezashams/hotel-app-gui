/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.controllers;

import com.hotel.web.model.BookedRoom;
import com.hotel.web.model.Invoice;
import com.hotel.web.model.Room;
import com.hotel.web.service.RoomService;
import com.hotel.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RoomController {
    private RoomService roomService;
    private UserService userService;

    public RoomController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @GetMapping("/rooms_mgn")
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "mgn_rooms";
    }

    @GetMapping("/rooms_mgn/new")
    public String createRoomForm(Model model) {

        Room room = new Room();
        model.addAttribute("room", room);
        return "create_room";

    }

    @PostMapping("/rooms_mgn")
    public String saveRoom(@ModelAttribute("room") Room room) {
        roomService.saveRoom(room);
        return "redirect:/rooms_mgn";
    }

    @GetMapping("/rooms_mgn/edit/{id}")
    public String editRoomForm(@PathVariable Long id, Model model) {
        model.addAttribute("room", roomService.getRoomId(id));
        return "edit_room";
    }

    @PostMapping("/rooms_mgn/{id}")
    public String updateRoom(@PathVariable Long id,
                                @ModelAttribute("room") Room room,
                                Model model) {

        Room existingRoom = roomService.getRoomId(id);
        existingRoom.setId(id);
        existingRoom.setPrice(room.getPrice());
        existingRoom.setDescription(room.getDescription());
        existingRoom.setName(room.getName());

        roomService.updateRoom(existingRoom);
        return "redirect:/rooms_mgn";
    }


    @GetMapping("/rooms_mgn/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomId(id);
        return "redirect:/rooms_mgn";
    }

    @GetMapping("/book_room")
    public String listBookRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "book_room";
    }

    @GetMapping("/select_room/{id}")
    public String selectRoom(@PathVariable Long id, Model model) {
        model.addAttribute("room", roomService.getRoomId(id));
        BookedRoom bookedRoom = new BookedRoom();
        bookedRoom.setRoomId(id);
        bookedRoom.setToDate(new Date());
        bookedRoom.setFromDate(new Date());
        model.addAttribute("bookedRoom", bookedRoom);

        return "edit_select_room";
    }



    @PostMapping("/invoice")
    public String invoice(@ModelAttribute("bookedRoom") BookedRoom bookedRoom,  Model model) {

        Room room = roomService.getRoomId(bookedRoom.getRoomId());
        Invoice invoice = new Invoice();
        invoice.setDate(new Date());
        invoice.setDateDiscount("0.0%");
        invoice.setStudentDiscount("50%");
        invoice.setRoomName(room.getName());
        invoice.setPrice(room.getPrice());
        invoice.setTotal(room.getPrice()/2);
        invoice.setFromDate(bookedRoom.getFromDate());
        invoice.setToDate(bookedRoom.getToDate());
        model.addAttribute("invoice", invoice);

        return "invoice";
    }

}
