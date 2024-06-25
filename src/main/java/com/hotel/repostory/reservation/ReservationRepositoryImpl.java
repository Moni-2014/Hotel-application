package com.hotel.repostory.reservation;

import com.hotel.model.customer.Customer;
import com.hotel.model.reservation.Reservation;
import com.hotel.model.reservation.ReservationImpl;
import com.hotel.model.room.Room;
import com.hotel.model.room.RoomImpl;
import com.hotel.model.room.enums.RoomType;

import java.util.*;
import java.util.stream.Collectors;

public class ReservationRepositoryImpl implements ReservationRepository{
    private static final int RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS = 7;
    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<String, Collection<Reservation>> reservations = new HashMap<>();

    public ReservationRepositoryImpl() {}


    public void addRoom(int roomNumber, double price, RoomType type) {
        Room newRoom = new RoomImpl(roomNumber, price, type);
        rooms.put(roomNumber, newRoom);
    }

    public Room getARoom(final int roomNumber) {
        return rooms.get(roomNumber);
    }

    public Collection<Room> getAllRooms() {
        return rooms.values();
    }

    public ReservationImpl reserveARoom(final Customer customer, final Room room,
                                        final Date checkInDate, final Date checkOutDate) {
        final ReservationImpl reservation = new ReservationImpl(customer, room, checkInDate, checkOutDate);
        reservations.putIfAbsent(customer.getEmail(), new LinkedList<>());

        Collection<Reservation> customerReservations = getCustomersReservation(customer);
        customerReservations.add(reservation);
        reservations.put(customer.getEmail(), customerReservations);

        return reservation;
    }

    public Collection<Room> findRooms(final Date checkInDate, final Date checkOutDate) {
        return findAvailableRooms(checkInDate, checkOutDate);
    }

    public Collection<Room> findAlternativeRooms(final Date checkInDate, final Date checkOutDate) {
        return findAvailableRooms(addDefaultPlusDays(checkInDate), addDefaultPlusDays(checkOutDate));
    }

    private Collection<Room> findAvailableRooms(final Date checkInDate, final Date checkOutDate) {
        final Collection<Reservation> allReservations = getAllReservations();
        final Collection<Room> notAvailableRooms = new LinkedList<>();

        for (Reservation reservation : allReservations) {
            if (reservationOverlaps(reservation, checkInDate, checkOutDate)) {
                notAvailableRooms.add(reservation.getRoom());
            }
        }

        return rooms.values().stream().filter(room -> notAvailableRooms.stream()
                .noneMatch(notAvailableRoom -> notAvailableRoom.equals(room)))
                .collect(Collectors.toList());
    }

    public Date addDefaultPlusDays(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS);

        return calendar.getTime();
    }

    private boolean reservationOverlaps(final Reservation reservation, final Date checkInDate,
                                        final Date checkOutDate){
        return checkInDate.before(reservation.getCheckOutDate())
                && checkOutDate.after(reservation.getCheckInDate());
    }

    public Collection<Reservation> getCustomersReservation(final Customer customer) {
        return reservations.get(customer.getEmail());
    }

    public Collection<Reservation> getAllReservations() {
        return reservations.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
