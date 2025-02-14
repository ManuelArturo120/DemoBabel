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
import static com.demo.constant.Constants.CHANNEL;
import static com.demo.constant.Constants.CONTENT_TYPE;
import static com.demo.constant.Constants.FLOW;

import static com.demo.constant.Constants.PNR;
import static com.demo.constant.Constants.STORE;
import static com.demo.constant.Constants.STRING_EMPTY;
import static com.demo.constant.Constants.X_TRANSACTION_ID;

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
        request.addHeader(CONTENT_TYPE, "application/json");
        request.addHeader(CHANNEL, "WEB");
        request.addHeader(FLOW, "myb");
        request.addHeader(X_TRANSACTION_ID, "ff978146-e8d5-46f7-ab47-3b35387299b4");
        request.addHeader(STORE, "mx");
        request.addHeader(PNR , "PVLRKP");

        return request;
    }

    
/*
    @Test
    void testServiceUnavailableDueToSabreDisconnection() throws Exception {

        String jsonRequest = UtilTest.getJsonToString("/request/RQ2.json");
        Gson gson = new Gson();
        GetAncillaryOffersRQ getAncillaryOffersRQ = gson.fromJson(jsonRequest, GetAncillaryOffersRQ.class);
        getAncillaryOffersRQ.setQueryByItinerary(new GetAncillaryOffersRQ.QueryByItinerary());
        CustomerDTO customerDTO = new CustomerDTO("web", "MYB" , "abc65970-5152-4dbb-8c1d-2661a4c2c054", "mx", "VIZUJK");
        doThrow(new SabreDisconnectionException(new Exception(), STRING_EMPTY, STRING_EMPTY)).when(ancillaryOfferService).getAncillaryOffersRS(getAncillaryOffersRQ, getAncillaryOffersRQ.getClientContext().getCityCode(), CITY_COMMAND, customerDTO);

        mockMvc.perform(post("/ab/ancillary/offer")
                        .header("flow", "MYB")
                        .header("pnr", "VIZUJK")
                        .header("store", "mx")
                        .header("x-transactionId", "abc65970-5152-4dbb-8c1d-2661a4c2c054")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("channel", "web"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.channel").value("web"))
                .andExpect(jsonPath("$.reason").value("ERR.AB.ANCILLARY.OFFER.BAD_REQUEST"))
                .andExpect(jsonPath("$.httpCode").value("400"));
    }

    @Test
    void testUnauthorizedDueToAuthenticationFailure() throws Exception {
        String jsonRequest = UtilTest.getJsonToString("/request/RQ2.json");
        Gson gson = new Gson();
        GetAncillaryOffersRQ getAncillaryOffersRQ = gson.fromJson(jsonRequest, GetAncillaryOffersRQ.class);
        getAncillaryOffersRQ.setQueryByItinerary(new GetAncillaryOffersRQ.QueryByItinerary());
        CustomerDTO customerDTO = new CustomerDTO("web", "MYB" , "abc65970-5152-4dbb-8c1d-2661a4c2c054", "mx", "VIZUJK");

        doThrow(new AuthenticationFailedException(new Exception("Authentication failed"))).when(ancillaryOfferService).getAncillaryOffersRS(getAncillaryOffersRQ, getAncillaryOffersRQ.getClientContext().getCityCode(), CITY_COMMAND, customerDTO);

        mockMvc.perform(post("/ab/ancillary/offer")
                        .header("flow", "MYB")
                        .header("pnr", "VIZUJK")
                        .header("store", "mx")
                        .header("x-transactionId", "abc65970-5152-4dbb-8c1d-2661a4c2c054")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("channel", "web"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.channel").value("web"))
                .andExpect(jsonPath("$.reason").value("ERR.AB.ANCILLARY.OFFER.BAD_REQUEST"))
                .andExpect(jsonPath("$.httpCode").value("400"));
    }
 @Test
    void testInternalServerErrorDueToServerErrorException() throws Exception {
          given(service.findALL())
                .willThrow(new ServerErrorException(STRING_EMPTY, new Exception()));

        mockMvc.perform(post("/getEmployed")
                        .header("flow", "MYB")
                        .header("pnr", "VIZUJK")
                        .header("store", "mx")
                        .header("x-transactionId", "abc65970-5152-4dbb-8c1d-2661a4c2c054")
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("channel", "web"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.channel").value("web"))
                .andExpect(jsonPath("$.reason").value("ERR.BAD_REQUEST"))
                .andExpect(jsonPath("$.httpCode").value("400"));
    }
*/
   
}

