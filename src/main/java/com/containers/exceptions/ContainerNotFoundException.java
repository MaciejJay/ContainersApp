package com.containers.exceptions;

public class ContainerNotFoundException extends RuntimeException {
    public ContainerNotFoundException(String message) {
        super(message);
    }
}
