package com.hotel.model.room.enums;

import com.hotel.exception.InvalidRoomTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class RoomTypeTest {


    @ParameterizedTest
    @EnumSource(RoomType.class)
    void valueOfLabel_Should_NotThrow_When_ExistingLabelIsPassed(RoomType type) {
        Assertions.assertDoesNotThrow(() -> RoomType.valueOfLabel(type.label));
    }

    @ParameterizedTest
    @EnumSource(RoomType.class)
    void valueOfLabel_Should_Throw_When_InvalidLabelIsPassed(RoomType type) {
        String invalidLabel = String.format("test %s", type.label);
        Assertions.assertThrows(InvalidRoomTypeException.class, () -> RoomType.valueOfLabel(invalidLabel));
    }

}