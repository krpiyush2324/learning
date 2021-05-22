package com.ucode.criteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ucode.criteria.model.Employee;
import com.ucode.criteria.repository.EmployeeRepository;
import com.ucode.criteria.specification.EmployeeSpecification;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("employee/{firstName}/{department}")
	public List<Employee> findByFirstNameAndDepartment(@PathVariable("firstName") String firstName,
			@PathVariable("department") String department) {
		List<Employee> findByFirstNameAndDepartment = repository.findByFirstNameAndDepartment(firstName, department);
		return findByFirstNameAndDepartment;
	}

	@GetMapping("employees/{firstName}/{department}")
	public List<Employee> findByFirstNameAndDepartmentusingSpecification(@PathVariable("firstName") String firstName,
			@PathVariable("department") String department) {

		Specification<Employee> specifications = Specification.where(
				EmployeeSpecification.hasFirstName(firstName).and(EmployeeSpecification.hasDepartment(department)));

		return repository.findAll(specifications);
	}

	@GetMapping("emp/{lastName}")
	public List<Employee> findByLastNameusingSpecification(@PathVariable("lastName") String lastName) {
		Specification<Employee> specifications = Specification.where(EmployeeSpecification.containsLastName(lastName));
		return repository.findAll(specifications);
	}
}
