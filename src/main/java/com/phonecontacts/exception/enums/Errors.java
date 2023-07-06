package com.phonecontacts.exception.enums;

import org.springframework.http.HttpStatus;

public enum Errors {

    USER_NOT_FOUND("USER_NOT_FOUND", "Sorry user not found!", HttpStatus.NOT_FOUND);

    final String key;
    final String message;
    final HttpStatus httpStatus;

    Errors(String key, String message, HttpStatus httpStatus) {
        this.key = key;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
