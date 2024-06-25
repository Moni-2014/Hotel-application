package com.hotel;

import com.hotel.api.AdminResource;
import com.hotel.api.HotelResource;
import com.hotel.repostory.customer.CustomerRepository;
import com.hotel.repostory.customer.CustomerRepositoryImpl;
import com.hotel.repostory.reservation.ReservationRepository;
import com.hotel.repostory.reservation.ReservationRepositoryImpl;

public class HotelApplication {

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        ReservationRepository reservationRepository = new ReservationRepositoryImpl();

        HotelResource hotelResource = new HotelResource(customerRepository, reservationRepository);
        AdminResource adminResource = new AdminResource(customerRepository, reservationRepository);

        AdminMenu adminMenu = new AdminMenu(adminResource);
        MainMenu mainMenu = new MainMenu(hotelResource, adminMenu);

        mainMenu.mainMenu();
    }
}
