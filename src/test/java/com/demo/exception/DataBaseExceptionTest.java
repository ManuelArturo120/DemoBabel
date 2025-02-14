package com.demo.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataBaseExceptionTest {

	
	 @Test
	    void internalServerError() {

		 DataBaseDisconnectionException error = new DataBaseDisconnectionException(new RuntimeException(),"some message");
	        assertNotNull(error.getRequest());
	        try {
	            throw error;
	        } catch (DataBaseDisconnectionException e) {
	            assertEquals("java.lang.RuntimeException", e.getMessage());
	        }
	    }
}
