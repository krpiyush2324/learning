package com.ucode.criteria.repository;

import java.util.List;

import com.ucode.criteria.model.Employee;

public interface EmployeeCustomRepository {

	List<Employee> findByFirstNameAndDepartment(String firstName, String department);
	
}
