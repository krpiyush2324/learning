package com.ucode.criteria.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.ucode.criteria.model.Employee;

@Component
public class EmployeeSpecification {

	public static Specification<Employee> hasFirstName(String firstName) {
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get("firstName"), firstName);
		});
	}
	
	public static Specification<Employee> containsLastName(String lastName) {
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.like(root.get("lastName"),"%"+ lastName + "%");
		});
	}
	
	public static Specification<Employee> hasDepartment(String department) {
		return ((root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.equal(root.get("department"), department);
		});
	}
	
	

}
