package com.demo.entities;

import java.util.Date;

import org.springframework.boot.context.properties.bind.Name;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "employed")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmployed;
	
	private String firstName;
	private String secondName;
	private String paternalSurname;
	private String maternalSurname;
	private int age;
	private String gender;
	private Date birthdate;
	private String position;
	
	public Employee() {
		// Constructor por defecto
	}
	
	public Employee(int age, String firtName, String secondName, String paternalSurname, 
					String maternalSurname, String gender, Date birthdate, String position) {
		this.firstName = firtName;
		this.secondName = secondName;
		this.paternalSurname = paternalSurname;
		this.maternalSurname = maternalSurname;
		this.age = age;
		this.gender = gender;
		this.birthdate = birthdate;
		this.position = position;
	}
}



