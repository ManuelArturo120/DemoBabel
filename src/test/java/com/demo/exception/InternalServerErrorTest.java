package com.demo.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class InternalServerErrorTest {

    @Test
    void ServerError() {

        InternalServerError internalServerError = new InternalServerError(new RuntimeException(), "some message");
        assertNotNull(internalServerError.getRequest());
        try {
            throw internalServerError;
        } catch (InternalServerError e) {
            assertEquals("java.lang.RuntimeException", e.getMessage());
        }
    }
}

