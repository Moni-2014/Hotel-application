package com.hotel.api;

import com.hotel.repostory.customer.CustomerRepository;
import com.hotel.repostory.reservation.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HotelResourceTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ReservationRepository reservationRepository;
    @InjectMocks
    private HotelResource hotelResource;

    @Test
    void getCustomer() {
    }

    @Test
    void createACustomer() {
    }

    @Test
    void getRoom() {
    }

    @Test
    void bookARoom() {
    }

    @Test
    void getCustomersReservations() {
    }

    @Test
    void findARoom() {
    }

    @Test
    void findAlternativeRooms() {
    }

    @Test
    void addDefaultPlusDays() {
    }
}