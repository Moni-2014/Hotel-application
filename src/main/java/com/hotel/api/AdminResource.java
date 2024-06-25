package com.hotel.api;

import com.hotel.model.customer.Customer;
import com.hotel.model.reservation.Reservation;
import com.hotel.model.room.Room;
import com.hotel.model.room.enums.RoomType;
import com.hotel.repostory.customer.CustomerRepository;
import com.hotel.repostory.reservation.ReservationRepository;

import java.util.Collection;

public class AdminResource {

    private final CustomerRepository customerService;
    private final ReservationRepository reservationRepository;

    public AdminResource(CustomerRepository customerService, ReservationRepository reservationRepository) {
        this.customerService = customerService;
        this.reservationRepository = reservationRepository;
    }

    public void addRoom(int roomNumber, double price, RoomType type) {
        reservationRepository.addRoom(roomNumber, price, type);
    }

    public Collection<Room> getAllRooms() {
        return reservationRepository.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {
        final Collection<Reservation> reservations = reservationRepository.getAllReservations();

        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation + "\n");
            }
        }
    }
}
