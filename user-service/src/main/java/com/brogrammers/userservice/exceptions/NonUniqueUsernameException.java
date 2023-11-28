package com.brogrammers.userservice.exceptions;

public class NonUniqueUsernameException extends RuntimeException {
    public NonUniqueUsernameException(String message) {
        super(message);
    }
}