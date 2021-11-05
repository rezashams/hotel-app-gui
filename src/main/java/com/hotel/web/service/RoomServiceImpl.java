/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */
package com.hotel.web.service;

import com.hotel.web.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    List<Room> rooms = new ArrayList<>();
    long id =0;
    @Override
    public List<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public Room saveRoom(Room room) {
        room.setId(++id);
        rooms.add(room);
        return room;
    }

    @Override
    public Room getRoomId(Long id) {

        return rooms.stream().filter(x->x.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Room updateRoom(Room room) {
        Room existRoom = rooms.stream().filter(x->x.getId()==id).findFirst().orElse(null);
        existRoom=room;
        return room;
    }

    @Override
    public void deleteRoomId(Long id) {
        rooms.removeIf(x->x.getId()==id);
    }
}
