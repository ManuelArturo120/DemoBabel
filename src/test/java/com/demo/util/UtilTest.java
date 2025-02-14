package com.demo.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.dto.request.EmployerRequest;
import com.demo.dto.response.EmployeeResponse;
import com.demor.dto.CustomerDTO;
import com.google.gson.Gson;

@SpringBootTest
public class UtilTest {
	
	

	
	 @Test
	    void toStrings() throws IllegalArgumentException, IOException {
	        String jsonRequest = UtilTest.getJsonToString("/request/RQ.json");
	        Gson gson = new Gson();
	        EmployerRequest request = gson.fromJson(jsonRequest, EmployerRequest.class);
	     
	        String jsonResponseClient = UtilTest.getJsonToString("/response/RS.json");
	        gson = new Gson();
	        EmployeeResponse response = gson.fromJson(jsonResponseClient, EmployeeResponse.class);

	        assertNotNull(request.toString());
	        assertNotNull(response.toString());


	    }
	 @Test
	    void toStrings2() throws IllegalArgumentException, IOException {
	        String jsonRequest = UtilTest.getJsonToString("/request/RQ2.json");
		        String jsonResponseClient = UtilTest.getJsonToString("/response/RS2.json");
	       
	        assertNotNull(jsonRequest);
	        assertNotNull(jsonResponseClient);


	    }
	 
	    public static String getJsonToString(String fileName)
	            throws IOException {

	        Class clazz = UtilTest.class;
	        InputStream inputStream = clazz.getResourceAsStream(fileName);

	        StringBuilder resultStringBuilder = new StringBuilder();
	        try (BufferedReader br
	                     = new BufferedReader(new InputStreamReader(inputStream))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                resultStringBuilder.append(line).append("\n");
	            }
	        }
	        return resultStringBuilder.toString();
	    }
	    public static CustomerDTO getCustomerDTO(){
	        CustomerDTO customerDTO= new CustomerDTO(null,null,null, null,null, null);
	        customerDTO.setPnr("GRTCHQ");
	        customerDTO.setFlow("myb");
	        customerDTO.setChannel("web");
	        customerDTO.setContentType("application/json");
	        customerDTO.setStore("mx");
	        customerDTO.setXTransactionId("62f19698-fc83-4401-af32-cc95d3ec7796");

	        return customerDTO;
	    }
}
