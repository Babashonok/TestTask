package com.epam.parking.service.exception;

/**
 * Exception, which appears when there are no free slot of the current type
 */

public class NoAvailableSlotsException extends Exception{
    public NoAvailableSlotsException(){
        super();
    }
    public NoAvailableSlotsException(String message) {
        super(message);
    }
    public NoAvailableSlotsException(Exception e) {
        super(e);
    }
    public NoAvailableSlotsException(String message, Exception e) {
        super(message, e);
    }
}
