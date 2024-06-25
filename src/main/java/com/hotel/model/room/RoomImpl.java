package com.hotel.model.room;

import com.hotel.model.room.enums.RoomType;

import java.util.Objects;

public class RoomImpl implements Room {

    private final int roomNumber;
    private final double price;
    private final RoomType type;

    public RoomImpl(final int roomNumber, final double price, final RoomType type) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.type = type;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }


    @Override
    public String toString() {
        return "Room Number: " + this.roomNumber
                + " Price: $" + this.price
                + " Enumeration: " + this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        return obj instanceof RoomImpl room && Objects.equals(this.roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
