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

		  @JsonProperty("firstName")
		  private String firstName;
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
