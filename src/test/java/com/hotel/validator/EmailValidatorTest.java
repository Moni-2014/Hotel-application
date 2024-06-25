package com.hotel.validator;

import com.hotel.exception.InvalidEmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @ParameterizedTest()
    @MethodSource("validEmailTestData")
    void validateEmail_Should_NotThrow_When_PatternMatches(String email) {
        Assertions.assertDoesNotThrow(() -> EmailValidator.validateEmail(email));
    }

    @ParameterizedTest()
    @MethodSource("invalidEmailTestData")
    void validateEmail_Should_Throw_When_PatternDoesNotMatch(String email) {
        Assertions.assertThrows(InvalidEmailException.class, () -> EmailValidator.validateEmail(email));
    }
    private static Stream<String> validEmailTestData() {
        return Stream.of("test@emai.com", "e@d.cg",
                "something@test.bg", "hq@spidersurvey.com");
    }

    private static Stream<String> invalidEmailTestData() {
        return Stream.of("test@emaicom", "ed.c",
                "something-bg", "hq_spidersurvey@com.");
    }
}