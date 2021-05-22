package com.ucode.criteria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.ucode.criteria.model.Employee;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

	@Autowired
	EntityManager entityManager;

	/**
	 * 
	 */
	@Override
	public List<Employee> findByFirstNameAndDepartment(String firstName, String department) {
		// TODO Auto-generated method stub

		//create criteriabuiler instance from entity manager
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		//create criteria query from criteria buider instance
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
       //create root instance from criteria query intance 
		Root<Employee> root = criteriaQuery.from(Employee.class);

		//create predicate for generating query
		Predicate firstNamePredicate = criteriaBuilder.equal(root.get("firstName"), firstName);
		Predicate departmentPredicate = criteriaBuilder.equal(root.get("department"), department);

		Predicate lastNamePredicate = criteriaBuilder.equal(root.get("lastName"), firstName);
//		Predicate departmentPredicate1 = criteriaBuilder.equal(root.get("department"), department);
//
		CriteriaQuery<Employee> where = criteriaQuery.where(firstNamePredicate, departmentPredicate);
		System.out.println("where  " + where.getRestriction().getExpressions().get(1));
		criteriaQuery.select(root);

		TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);

		List<Employee> resultList = query.getResultList();
		System.out.println(resultList.get(0).getFirstName());
		return resultList;
	}

}
