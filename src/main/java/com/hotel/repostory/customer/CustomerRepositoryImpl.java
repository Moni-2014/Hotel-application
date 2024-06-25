package com.hotel.repostory.customer;

import com.hotel.model.customer.Customer;
import com.hotel.model.customer.CustomerImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<String, Customer> customers = new HashMap<>();

    public CustomerRepositoryImpl() {}

    public void addCustomer(final String email, final String firstName, final String lastName) {
        customers.put(email, new CustomerImpl(firstName, lastName, email));
    }

    public Customer getCustomer(final String customerEmail) {
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
