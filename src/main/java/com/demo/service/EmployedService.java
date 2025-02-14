package com.demo.service;

import java.util.List;

import com.demo.dto.request.EmployerRequest;
import com.demo.dto.response.EmployeeResponse;
import com.demo.entities.Employee;
import com.demo.exception.InternalServerError;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface EmployedService {

	
	List<EmployeeResponse> findALL() throws InternalServerError, JsonProcessingException;
	
	List<EmployeeResponse> addEmplotyed(List<EmployerRequest> employed) throws InternalServerError, JsonProcessingException;
	
	
	Employee  updateEmployed (EmployerRequest employed, long id) throws InternalServerError;
	
	void deleteEmployed (long id);
	
	
}
