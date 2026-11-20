package com.iker.stockify.exceptions;

public class UserDontExistsException extends RuntimeException {
    public UserDontExistsException(String message) {
        super(message);
    }
}
