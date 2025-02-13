package com.demo.dto.response;

import java.io.Serializable;
import java.util.Date;

import com.demo.entities.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse implements Serializable{
	
	
	public EmployeeResponse(Employee s) {
		this.idEmployed = s.getIdEmployed();
		this.age=s.getAge();
		this.firtName= s.getFirtName();
		this.secondName= s.getSecondName();
		this.paternalSurname= s.getPaternalSurname();
		this.maternalSurname= s.getMaternalSurname();
		this.gender= s.getGender();
		this.birthdate= s.getBirthdate();
		this.position= s.getPosition();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  @JsonProperty("idEmployed")
	private long idEmployed;
	  @JsonProperty("firtName")
	private String firtName;
	  @JsonProperty("secondName")
	private String secondName;
	  @JsonProperty("paternalSurname")
	private String paternalSurname;
	  @JsonProperty("maternalSurname")
	private String maternalSurname;
	  @JsonProperty("age")
	private int age;
	  @JsonProperty("gender")
	private String gender;
	  @JsonProperty("birthdate")
	private Date birthdate;
	  @JsonProperty("position")
	private String position;

}
