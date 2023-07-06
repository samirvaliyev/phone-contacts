package com.phonecontacts.exception;

public class AccessDeniedContactUpdateException extends RuntimeException {

    public static final String ACCESS_DENIED_CONTACT = "Sorry, access denied operation for this role";

    public AccessDeniedContactUpdateException() {
        super(ACCESS_DENIED_CONTACT);
    }
}
