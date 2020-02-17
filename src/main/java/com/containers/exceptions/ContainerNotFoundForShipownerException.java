package com.containers.exceptions;

public class ContainerNotFoundForShipownerException extends RuntimeException {
    public ContainerNotFoundForShipownerException(String message) {
        super(message);
    }
}
