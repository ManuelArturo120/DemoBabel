package com.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.util.UtilTest;


@SpringBootTest
@AutoConfigureMockMvc
@Profile("test")
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EmployedControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void addEmployedBadRequest() throws Exception  {
        String jsonRequest = UtilTest.getJsonToString("/request/RQ.json");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/addEmployed")
                .content(jsonRequest)
                .header("content-type", "application/json"))
        .andExpect(status().isBadRequest());
    }
    @Test
    void addEmployedSucces() throws Exception  {
        String jsonRequest = UtilTest.getJsonToString("/request/RQ2.json");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/addEmployed")
                .content(jsonRequest)
                .header("content-type", "application/json"))
        .andExpect(status().isOk());
    }
    @Test
    void getEmployedSucces() throws Exception  {
        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/getEmployed")
                .header("content-type", "application/json"))
        .andExpect(status().isOk());
    }
    @Test
    void updateEmployedSucces() throws Exception  {
        
    	  String jsonRequest = UtilTest.getJsonToString("/request/RQ.json");

          mockMvc.perform(MockMvcRequestBuilders
                  .patch("/updateEmployed")
                  .content(jsonRequest)
                  .param("id", "9")
                  .header("content-type", "application/json"))
          .andExpect(status().isOk());
    }
    @Test
    void updateEmployedBadRequest() throws Exception  {
        
    	  String jsonRequest = UtilTest.getJsonToString("/request/RQ2.json");

          mockMvc.perform(MockMvcRequestBuilders
                  .patch("/updateEmployed")
                  .content(jsonRequest)
                  .param("id", "8")
                  .header("content-type", "application/json"))
          .andExpect(status().isBadRequest());
    }
    @Test
    void deleteEmployedSucces() throws Exception  {

          mockMvc.perform(MockMvcRequestBuilders
                  .delete("/deleteEmployed")
                  .param("id", "8")
                  .header("content-type", "application/json"))
          .andExpect(status().isOk());
    }
    @Test
    void deleteEmployedBadRequest() throws Exception  {
        
    	  String jsonRequest = UtilTest.getJsonToString("/request/RQ2.json");

          mockMvc.perform(MockMvcRequestBuilders
                  .delete("/deleteEmployed")
                  .content(jsonRequest)
                  .header("content-type", "application/json"))
          .andExpect(status().isBadRequest());
    }
}
