package com.demo.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demor.dto.LogStructure;

@SpringBootTest
class LogStructureTest {

    @Test
    void testLogStructure(){
        LogStructure logStructure = new LogStructure("req", "resp", "some exception");

        String log = logStructure.getTransactionLog();

        LogStructure.builder().build();
        LogStructure.builder().toString();
        LogStructure.builder().request("req");
        LogStructure.builder().response("resp");
        LogStructure.builder().exceptionMessage("some excp");

        Assertions.assertNotNull(log);
    }

    @Test
    void testLogStructureException(){
        LogStructure logStructure = new LogStructure("req", "resp", "some exception");

        String log = logStructure.getExceptionLog();

        LogStructure.builder().build();
        LogStructure.builder().toString();
          LogStructure.builder().request("req");
        LogStructure.builder().response("resp");
        LogStructure.builder().exceptionMessage("some excp");
      
        Assertions.assertNotNull(log);
    }
}
