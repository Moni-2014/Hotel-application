package com.hotel.exception;

public class InvalidRoomTypeException extends RuntimeException {

    public InvalidRoomTypeException() {
        super("Invalid room type! Please, choose 1 for single bed or 2 for double bed:");
    }

}
