package com.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException {



	public String getInvalidHeaders() {
		return invalidHeaders;
	}

	public String getRequest() {
		return request;
	}

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private final String invalidHeaders;
    private final String request;

    public BadRequestException(Throwable cause, String invalidHeaders, String request) {
        super(cause);
        this.invalidHeaders = invalidHeaders;
        this.request = request;
    }
}
