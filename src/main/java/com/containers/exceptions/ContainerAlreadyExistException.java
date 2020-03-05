package com.containers.exceptions;

public class ContainerAlreadyExistException extends RuntimeException {
    public ContainerAlreadyExistException(String message) {
        super(message);
    }
}
