package com.devmarcotulio.api.exceptions;

public class EmailAlreadyUsed extends RuntimeException {

    public EmailAlreadyUsed(String message) {
        super(message);
    }

    public EmailAlreadyUsed(String message, Throwable cause) {
        super(message, cause);
    }
}
