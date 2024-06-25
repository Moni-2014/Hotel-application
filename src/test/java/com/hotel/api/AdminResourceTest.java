package com.hotel.api;

import com.hotel.model.customer.Customer;
import com.hotel.model.customer.CustomerImpl;
import com.hotel.model.room.Room;
import com.hotel.model.room.RoomImpl;
import com.hotel.model.room.enums.RoomType;
import com.hotel.repostory.customer.CustomerRepository;
import com.hotel.repostory.reservation.ReservationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AdminResourceTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ReservationRepository reservationRepository;
    @InjectMocks
    private AdminResource adminResource;

    @Test
    void getAllRooms_Should_ReturnEmptyCollection_When_RepoReturnEmptyCollection() {
        Collection<Room> rooms = Collections.emptyList();
        Mockito.when(reservationRepository.getAllRooms()).thenReturn(rooms);

        Collection<Room> actual = adminResource.getAllRooms();

        Assertions.assertEquals(rooms, actual);
    }

    @Test
    void getAllRooms_Should_ReturnRooms_When_RepoReturnsRooms() {
        Collection<Room> rooms = List.of(new RoomImpl(1234, 34.2, RoomType.DOUBLE),
                new RoomImpl(54322133, 23.1, RoomType.SINGLE));
        Mockito.when(reservationRepository.getAllRooms()).thenReturn(rooms);

        Collection<Room> actual = adminResource.getAllRooms();

        Assertions.assertEquals(rooms, actual);
    }

    @Test
    void getAllCustomers_Should_ReturnEmptyCollection_When_RepoReturnEmptyCollection() {
        Collection<Customer> customers = Collections.emptyList();
        Mockito.when(customerRepository.getAllCustomers()).thenReturn(customers);

        Collection<Customer> actual = adminResource.getAllCustomers();

        Assertions.assertEquals(customers, actual);
    }

    @Test
    void getAllCustomers_Should_ReturnCustomers_When_RepoReturnsCustomers() {
        Collection<Customer> customers = List.of(new CustomerImpl("Ivan", "Petkov", "petkov@as.ds"),
                new CustomerImpl("Pesho", "Ivanov", "pesho@as.ds"));
        Mockito.when(customerRepository.getAllCustomers()).thenReturn(customers);

        Collection<Customer> actual = adminResource.getAllCustomers();

        Assertions.assertEquals(customers, actual);
    }
}