package com.facade.ehrbridge.exception;

public class EhrServiceException extends RuntimeException{
    public EhrServiceException(String message){
        super(message);
    }

    public EhrServiceException (String message, Throwable cause) {
        super(message,cause);
    }
}
