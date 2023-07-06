package com.phonecontacts.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public static final String ALREADY_EXISTS_USER = "User already exists in DB, please choose different email";

    public UserAlreadyExistsException() {
        super(ALREADY_EXISTS_USER);
    }
}
