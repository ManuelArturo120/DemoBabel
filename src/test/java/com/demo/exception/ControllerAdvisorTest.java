package com.demo.exception;

import com.demo.dto.request.EmployerRequest;
import com.demo.service.EmployedService;
import com.demo.util.UtilTest;
import com.demor.dto.CustomerDTO;
import com.google.gson.Gson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.MethodParameter;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.method.MethodValidationResult;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.server.ServerErrorException;

import java.lang.reflect.Method;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import static com.demo.constant.Constants.STRING_EMPTY;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerAdvisorTest {
    @Autowired
    private MockMvc mockMvc;


    @InjectMocks
    ControllerAdvisor controllerAdvisor;
    
    @Autowired
    EmployedService service;


    @Test
    void handleHttpMessageNotReadable() throws NoSuchMethodException {

        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        BeanPropertyBindingResult errors = new BeanPropertyBindingResult(UtilTest.getCustomerDTO(), "customerDTO");
        errors.rejectValue("store", "invalid");
        MethodParameter parameter = new MethodParameter(CustomerDTO.class.getMethod("getStore"), -1);
        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(parameter, errors);
        try {
            controllerAdvisor.handleHttpMessageNotReadable(ex, getHttpServletRequest());
        } catch (Exception e) {
            assertNotNull(e.getMessage());
        }
    }

  


       @Test
    void handleInternalServerError() {

        InternalServerError internalServerError = new InternalServerError(new RuntimeException("Some error"), "");
        try {
            ResponseEntity<Object> resp = controllerAdvisor.handleInternalServerError(internalServerError, getHttpServletRequest());
            Assertions.assertEquals(500, resp.getStatusCode().value());
            assertNotNull(resp.getBody());
        } catch (Exception e) {
            assertNotNull(e.getMessage());
        }
    }

   
  



    private MockHttpServletRequest getHttpServletRequest(){

        MockHttpServletRequest request = new MockHttpServletRequest();


        return request;
    }


   
}

