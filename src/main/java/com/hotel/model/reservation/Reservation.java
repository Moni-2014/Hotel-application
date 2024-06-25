package com.hotel.model.reservation;

import com.hotel.model.room.Room;

import java.util.Date;

public interface Reservation {
    Room getRoom();
    Date getCheckInDate();
    Date getCheckOutDate();

}
