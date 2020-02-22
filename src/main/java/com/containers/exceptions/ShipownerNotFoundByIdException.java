package com.containers.exceptions;

public class ShipownerNotFoundByIdException extends RuntimeException {
    public ShipownerNotFoundByIdException(String message) {
        super(message);
    }
}
