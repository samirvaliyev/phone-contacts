package com.phonecontacts.exception;

import com.phonecontacts.exception.enums.Errors;
import com.phonecontacts.exception.resource.ErrorResponseResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseResource> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponseResource exception = new ErrorResponseResource(Errors.USER_NOT_FOUND.name(),
                ex.getLocalizedMessage(), LocalDateTime.now().toString());
        log.error("User not found exception   {}", exception);
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
