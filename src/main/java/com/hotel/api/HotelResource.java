package com.hotel.api;

import com.hotel.model.customer.Customer;
import com.hotel.model.reservation.Reservation;
import com.hotel.model.room.Room;
import com.hotel.repostory.customer.CustomerRepository;
import com.hotel.repostory.reservation.ReservationRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;


public class HotelResource {

    private final CustomerRepository customerService;
    private final ReservationRepository reservationService;

    public HotelResource(CustomerRepository customerRepository, ReservationRepository reservationService) {
        this.customerService = customerRepository;
        this.reservationService = reservationService;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public Room getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, Room room, Date checkInDate, Date checkOutDate) {
        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        final Customer customer = getCustomer(customerEmail);

        if (customer == null) {
            return Collections.emptyList();
        }

        return reservationService.getCustomersReservation(customer);
    }

    public Collection<Room> findARoom(final Date checkIn, final Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

    public Collection<Room> findAlternativeRooms(final Date checkIn, final Date checkOut) {
        return reservationService.findAlternativeRooms(checkIn, checkOut);
    }

    public Date addDefaultPlusDays(final Date date) {
        return reservationService.addDefaultPlusDays(date);
    }
}
