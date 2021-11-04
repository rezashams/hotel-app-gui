/*
 * Copyright (c) 2021 Birmingham City University. All rights reserved.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */

package com.hotel.web.service;

import com.hotel.web.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();

    Room saveRoom(Room room);

    Room getRoomId(Long id);

    Room updateRoom(Room room);

    void deleteRoomId(Long id);

}
