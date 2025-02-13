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
@Table(name ="employee")
@Setter
@Getter
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")

    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
	private long idEmployed;

	private String firtName;
	private String secondName;
	private String paternalSurname;
	private String maternalSurname;
	private int age;
	private String gender;
	private Date birthdate;
	private String position;
	public long getIdEmployed() {
		return idEmployed;
	}

	public Employee() {
		
	}
	public Employee(int age, String firtName, String secondName, String paternalSurname, String maternalSurname,
			String gender, Date birthdate, String position) {
		this.firtName = firtName;
		this.secondName = secondName;
		this.paternalSurname = paternalSurname;
		this.maternalSurname = maternalSurname;
		this.age = age;
		this.gender = gender;
		this.birthdate = birthdate;
		this.position = position;
		// TODO Auto-generated constructor stub
	}
	public Employee(int age2, String firstName, String secondName2, String paternalSurname2, String paternalSurname3,
			String maternalSurname2, Date birthdate2, String gender2, String position2) {
		// TODO Auto-generated constructor stub
	}

	public void setIdEmployed(long idEmployed) {
		this.idEmployed = idEmployed;
	}
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getPaternalSurname() {
		return paternalSurname;
	}
	public void setPaternalSurname(String paternalSurname) {
		this.paternalSurname = paternalSurname;
	}
	public String getMaternalSurname() {
		return maternalSurname;
	}
	public void setMaternalSurname(String maternalSurname) {
		this.maternalSurname = maternalSurname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
