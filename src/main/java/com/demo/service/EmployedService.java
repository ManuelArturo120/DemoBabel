package com.demo.service;

import java.util.List;

import com.demo.dto.request.EmployerRequest;
import com.demo.dto.response.EmployeeResponse;
import com.demo.entities.Employee;


public interface EmployedService {

	
	List<EmployeeResponse> findALL();
	
	List<EmployeeResponse> addEmplotyed(List<EmployerRequest> employed);
	
	
	Employee  updateEmployed (EmployerRequest employed, long id);
	
	void deleteEmployed (long id);
	
	
}
