package com.demo.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class InternalServerError extends Exception{


    @Serial
    private static final long serialVersionUID = 1L;

    private final String request;

    public InternalServerError(Throwable cause, String request) {
        super(cause);
        this.request = request;
    }

}