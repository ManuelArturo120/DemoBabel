package com.demo.dto.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class EmployerRequest  implements Serializable{


	private static final long serialVersionUID = 1L;

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
