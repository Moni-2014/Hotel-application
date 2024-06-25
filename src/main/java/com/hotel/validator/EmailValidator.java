package com.hotel.validator;

import com.hotel.exception.InvalidEmailException;

import java.util.regex.Pattern;

public final class EmailValidator {
    private static  final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private  EmailValidator() {
        // Utility class. No instances.
    }

    public static void validateEmail(String email) {
        if(!emailPattern.matcher(email).matches()) {
            throw new InvalidEmailException();
        }
    }
}
