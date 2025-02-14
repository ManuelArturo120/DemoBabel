package com.demo.utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.dto.request.EmployerRequest;
import com.demo.dto.response.EmployeeResponse;
import com.demo.entities.Employee;
import org.apache.commons.lang3.StringUtils;

public class EmployeUtils {
	
	  public static List<Employee> convertRequestToModel(List<EmployerRequest> requestList) {
	        return requestList.stream()
	                .map(s -> new Employee(
	                		s.getAge(),
	                		s.getFirstName(),
	                		 s.getSecondName(),
	                		s.getPaternalSurname(),
	                		s.getMaternalSurname(),
	                		s.getGender(),
	                		s.getBirthdate(),
	                		s.getPosition()))
	                .collect(Collectors.toList());
	    }
	  
	  public static List<EmployeeResponse> converrtModelToResponse (List<Employee> model) {
		  return model.stream()
				    .map(s -> new EmployeeResponse(s)).collect(Collectors.toList());
	  }
	  
	  public void validUpdate(EmployerRequest request, Employee dao) {
		    // Verificar la edad, si es 0, usar la del dao
		    dao.setAge(request.getAge() != 0 ? request.getAge() : dao.getAge());

		    // Verificar campos de texto para nulos o vacíos
		    dao.setFirstName(StringUtils.isNotEmpty(request.getFirstName()) ? request.getFirstName() : dao.getFirstName());
		    dao.setSecondName(StringUtils.isNotEmpty(request.getSecondName()) ? request.getSecondName() : dao.getSecondName());
		    dao.setPaternalSurname(StringUtils.isNotEmpty(request.getPaternalSurname()) ? request.getPaternalSurname() : dao.getPaternalSurname());
		    dao.setMaternalSurname(StringUtils.isNotEmpty(request.getMaternalSurname()) ? request.getMaternalSurname() : dao.getMaternalSurname());

		    // Verificar fecha de nacimiento
		    dao.setBirthdate(request.getBirthdate() != null ? request.getBirthdate() : dao.getBirthdate());

		    // Verificar género
		    dao.setGender(StringUtils.isNotEmpty(request.getGender()) ? request.getGender() : dao.getGender());

		    // Verificar posición
		    dao.setPosition(StringUtils.isNotEmpty(request.getPosition()) ? request.getPosition() : dao.getPosition());
		}



}
