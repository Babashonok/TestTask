package com.epam.parking.service.exception;

/**
 * Exception, which appears when user try to add invalid entity (Vehicle or Slot)
 */
public class RegisterEntityException extends Exception {

    public RegisterEntityException(){
        super();
    }
    public RegisterEntityException(String message) {
        super(message);
    }
    public RegisterEntityException(Exception e) {
        super(e);
    }
    public RegisterEntityException(String message, Exception e) {
        super(message, e);
    }
}
