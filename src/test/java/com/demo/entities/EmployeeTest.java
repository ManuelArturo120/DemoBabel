package com.demo.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee(30, "John", "Michael", "Doe", "Smith", "Male", new Date(), "Software Engineer");
    }

    @Test
    void testEmployeeConstructor() {
        assertThat(employee.getFirstName()).isEqualTo("John");
        assertThat(employee.getSecondName()).isEqualTo("Michael");
        assertThat(employee.getPaternalSurname()).isEqualTo("Doe");
        assertThat(employee.getMaternalSurname()).isEqualTo("Smith");
        assertThat(employee.getAge()).isEqualTo(30);
        assertThat(employee.getGender()).isEqualTo("Male");
        assertThat(employee.getPosition()).isEqualTo("Software Engineer");
        assertThat(employee.getBirthdate()).isNotNull();
    }

    @Test
    void testSettersAndGetters() {
        employee.setFirstName("Jane");
        employee.setAge(25);
        employee.setPosition("Project Manager");

        assertThat(employee.getFirstName()).isEqualTo("Jane");
        assertThat(employee.getAge()).isEqualTo(25);
        assertThat(employee.getPosition()).isEqualTo("Project Manager");
    }

    @Test
    void testEqualsAndHashCode() {
        Employee anotherEmployee = new Employee(30, "John", "Michael", "Doe", "Smith", "Male", employee.getBirthdate(), "Software Engineer");
        assertThat(employee).isEqualTo(anotherEmployee);
        assertThat(employee.hashCode()).isEqualTo(anotherEmployee.hashCode());
    }
}
