package com.ucode.storeprocedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ucode.storeprocedure.model.Employee;
import com.ucode.storeprocedure.repository.EmployeeDao;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@GetMapping("/employee")
	public List<Employee> getEmployeeList() {
		return employeeDao.getEmployeeDetails();
	}
	
	
	@GetMapping("/employee/{category}")
	public List<Employee> getEmployeeListByCategory(@PathVariable("category") String category) {
		return employeeDao.getEmployeeByCategory(category);
	}

}
