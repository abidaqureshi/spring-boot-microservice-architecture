package com.rakutan.usersservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    //Extra properties to manager
    public ResourceNotFoundException() {
        super("Resource not found on server !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
