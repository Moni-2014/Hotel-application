package com.hotel.repostory.customer;

import com.hotel.model.customer.Customer;

import java.util.Collection;

public interface CustomerRepository {

    void addCustomer(final String email, final String firstName, final String lastName);
    Customer getCustomer(String email);
    Collection<Customer> getAllCustomers();

}
