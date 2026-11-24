package com.iker.stockify.exceptions;

public class ProductDoesntExistsException extends RuntimeException {
    public ProductDoesntExistsException(String message) {
        super(message);
    }
}
