package com.phonecontacts.exception;

import com.phonecontacts.exception.enums.Errors;
import com.phonecontacts.exception.resource.ErrorResponseResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<List<String>> processUnmergeException(final MethodArgumentNotValidException ex) {

        List<String> list = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedContactUpdateException.class)
    public ResponseEntity<ErrorResponseResource> handleAccessDeniedContactUpdateException(AccessDeniedContactUpdateException ex) {
        ErrorResponseResource exception = new ErrorResponseResource(Errors.ACCESS_DENIED_CONTACT.name(),
                ex.getLocalizedMessage(), LocalDateTime.now().toString());
        log.error("Access denied contact exception  {}", exception);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ErrorResponseResource> handleWrongPasswordException(WrongPasswordException ex) {
        ErrorResponseResource exception = new ErrorResponseResource(Errors.USER_WRONG_PASSWORD.name(),
                ex.getLocalizedMessage(), LocalDateTime.now().toString());
        log.error("User password wrong exception  {}", exception);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ErrorResponseResource> handleContactNotFoundException(ContactNotFoundException ex) {
        ErrorResponseResource exception = new ErrorResponseResource(Errors.CONTACT_NOT_FOUND.name(),
                ex.getLocalizedMessage(), LocalDateTime.now().toString());
        log.error("Contact not found exception   {}", exception);
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseResource> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        ErrorResponseResource exception = new ErrorResponseResource(Errors.USER_ALREADY_EXISTS.name(),
                ex.getLocalizedMessage(), LocalDateTime.now().toString());
        log.error("User already exists exception   {}", exception);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseResource> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponseResource exception = new ErrorResponseResource(Errors.USER_NOT_FOUND.name(),
                ex.getLocalizedMessage(), LocalDateTime.now().toString());
        log.error("User not found exception   {}", exception);
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
