package com.phonecontacts.exception.enums;

import org.springframework.http.HttpStatus;

public enum Errors {

    USER_NOT_FOUND("USER_NOT_FOUND", "Sorry user not found!", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("USER_ALREADY_EXISTS", "User email already exists!", HttpStatus.BAD_REQUEST),
    CONTACT_NOT_FOUND("CONTACT_NOT_FOUND", "Contact not found!", HttpStatus.NOT_FOUND),
    USER_WRONG_PASSWORD("USER_WRONG_PASSWORD", "User password wrong!", HttpStatus.BAD_REQUEST),
    ACCESS_DENIED_CONTACT("ACCESS_DENIED_CONTACT", "Access denied contact!", HttpStatus.BAD_REQUEST);

    final String key;
    final String message;
    final HttpStatus httpStatus;

    Errors(String key, String message, HttpStatus httpStatus) {
        this.key = key;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
