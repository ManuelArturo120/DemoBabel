package com.demo.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BadRequestExceptionTest {

    @Test
    void internalServerError() {

    	BadRequestException error = new BadRequestException(new RuntimeException(),"","some message");
        assertNotNull(error.getRequest());
        try {
            throw error;
        } catch (BadRequestException e) {
            assertEquals("java.lang.RuntimeException", e.getMessage());
        }
    }
}

