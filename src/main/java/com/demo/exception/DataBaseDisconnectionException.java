package com.demo.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataBaseDisconnectionException extends RuntimeException {

	
    private static final long serialVersionUID = 1L;
    
    private final String request;

    public DataBaseDisconnectionException(Throwable cause, String request) {
        super(cause);
        this.request = request;

    }


}
