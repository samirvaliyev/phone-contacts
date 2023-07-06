package com.phonecontacts.exception;

public class WrongPasswordException extends RuntimeException {

    public static final String WRONG_PASSWORD = "Wrong password, please enter correct password";

    public WrongPasswordException() {
        super(WRONG_PASSWORD);
    }
}
