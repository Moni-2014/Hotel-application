package com.hotel.model.customer;

import com.hotel.exception.InvalidEmailException;
import com.hotel.validator.EmailValidator;

import java.util.regex.Pattern;


public final class CustomerImpl implements Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    public CustomerImpl(final String firstName, final String lastName, final String email) {
        this.firstName = firstName;
        this.lastName = lastName;

        EmailValidator.validateEmail(email);
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "First Name: " + this.firstName
                + " Last Name: " + this.lastName
                + " Email: " + this.email;
    }
}
