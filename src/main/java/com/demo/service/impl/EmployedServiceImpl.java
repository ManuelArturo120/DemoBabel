package com.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.demo.dto.request.EmployerRequest;
import com.demo.dto.response.EmployeeResponse;
import com.demo.entities.Employee;
import com.demo.exception.DataBaseDisconnectionExcetion;
import com.demo.exception.InternalServerError;
import com.demo.repository.EmployedRepository;
import com.demo.service.EmployedService;
import com.demo.utils.EmployeUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.transaction.Transactional;

@Service
@Validated
public class EmployedServiceImpl implements  EmployedService {

	@Autowired
	private EmployedRepository repostory;
	
	//private EmployeUtils utils;
	
	@Override
	public List<EmployeeResponse> findALL()  throws InternalServerError, JsonProcessingException {
		
		 try {

				List<Employee> dao =repostory.findAll();
				 return EmployeUtils.converrtModelToResponse(dao);	    
				 }catch( DataBaseDisconnectionExcetion ex) {
	            throw ex;
	        } catch (Exception e) {
	            throw new InternalServerError(e,null);
	        }


	}

	@Override
	@Transactional
	public List<EmployeeResponse> addEmplotyed(List<EmployerRequest> employed)  throws InternalServerError, JsonProcessingException{
		 try {
		List<Employee> dao= repostory.saveAll(EmployeUtils.convertRequestToModel(employed));
		 return EmployeUtils.converrtModelToResponse(dao);
			 }catch( DataBaseDisconnectionExcetion ex) {
				 throw ex;
			 } catch (Exception e) {
		   throw new InternalServerError(e,employed.toString());
			 }
	}
	
	

	@Override
	public Employee updateEmployed(EmployerRequest employed, long id) throws InternalServerError {
		try {
		EmployeUtils utils = new EmployeUtils();
        Employee employee = repostory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + id));

	        	utils.validUpdate(employed, employee);
	        	 return repostory.save(employee);
			 }catch( DataBaseDisconnectionExcetion ex) {
				 throw ex;
			 } catch (Exception e) {
		   throw new InternalServerError(e,employed.toString());
			 }
	}
	@Override
	public void deleteEmployed(long id) {
		repostory.deleteById(id);
		
	}
	
	




}
