package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.demo.dto.request.EmployerRequest;
import com.demo.dto.response.EmployeeResponse;
import com.demo.entities.Employee;
import com.demo.repository.EmployedRepository;
import com.demo.service.EmployedService;
import com.demo.utils.EmployeUtils;

import jakarta.transaction.Transactional;

@Service
public class EmployedServiceImpl implements  EmployedService {

	@Autowired
	private EmployedRepository repostory;
	
	//private EmployeUtils utils;
	
	@Override
	public List<EmployeeResponse> findALL() {
		List<Employee> dao =repostory.findAll();
		 return EmployeUtils.converrtModelToResponse(dao);
	}

	@Override
	@Transactional
	public List<EmployeeResponse> addEmplotyed(List<EmployerRequest> employed) {
		List<Employee> dao= repostory.saveAll(EmployeUtils.convertRequestToModel(employed));
		 return EmployeUtils.converrtModelToResponse(dao);
		
	}
	
	

	@Override
	public Employee updateEmployed(EmployerRequest employed, long id) {
		EmployeUtils utils = new EmployeUtils();
        Employee employee = repostory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + id));

	        	utils.validUpdate(employed, employee);
	        	 return repostory.save(employee);
	}
	@Override
	public void deleteEmployed(long id) {
		repostory.deleteById(id);
		
	}
	
	




}
