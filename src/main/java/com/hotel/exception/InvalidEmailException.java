package com.hotel.exception;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException() {
        super("Invalid Email format!");
    }
}
