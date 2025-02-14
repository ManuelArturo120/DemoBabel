package com.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataBaseDisconnectionExcetion extends RuntimeException {

	
    private static final long serialVersionUID = 1L;
    
    private final String request;

    public DataBaseDisconnectionExcetion(Throwable cause, String request) {
        super(cause);
        this.request = request;

    }
}
