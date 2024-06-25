package com.hotel.repostory.reservation;

import com.hotel.model.customer.Customer;
import com.hotel.model.reservation.Reservation;
import com.hotel.model.room.Room;
import com.hotel.model.room.enums.RoomType;

import java.util.Collection;
import java.util.Date;

public interface ReservationRepository {
    void addRoom(String roomNumber, double price, RoomType type);
    Collection<Room> getAllRooms();
    Collection<Reservation> getAllReservations();
    Room getARoom(String roomNumber);
    Collection<Reservation> getCustomersReservation(Customer customer);
    Collection<Room> findRooms(Date checkIn, Date checkOut);
    Collection<Room> findAlternativeRooms(Date checkIn, Date checkOut);
    Date addDefaultPlusDays(Date date);
    Reservation reserveARoom(Customer customer, Room room, Date checkInDate, Date checkOutDate);
}
