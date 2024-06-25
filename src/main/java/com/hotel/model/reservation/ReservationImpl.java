package com.hotel.model.reservation;

import com.hotel.model.customer.Customer;
import com.hotel.model.room.Room;

import java.util.Date;

public final class ReservationImpl implements Reservation {

    private final Customer customer;
    private final Room room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public ReservationImpl(final Customer customer, final Room room,
                           final Date checkInDate, final Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public Room getRoom() {
        return this.room;
    }
    @Override
    public Date getCheckInDate() {
        return this.checkInDate;
    }
    @Override
    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    @Override
    public String toString() {
        return "Customer: " + this.customer.toString()
                + "\nRoom: " + this.room.toString()
                + "\nCheckIn Date: " + this.checkInDate
                + "\nCheckOut Date: " + this.checkOutDate;
    }
}
