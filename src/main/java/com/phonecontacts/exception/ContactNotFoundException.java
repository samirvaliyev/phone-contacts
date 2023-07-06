package com.phonecontacts.exception;

public class ContactNotFoundException extends RuntimeException {

    public static final String CONTACT_NOT_FOUND = "This is contact not found!";

    public ContactNotFoundException() {
        super(CONTACT_NOT_FOUND);
    }
}
