package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Employee;



public interface EmployedRepository extends JpaRepository<Employee, Long>{

	
	
}
