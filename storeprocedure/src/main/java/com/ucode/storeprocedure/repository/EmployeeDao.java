package com.ucode.storeprocedure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ucode.storeprocedure.model.Employee;

@Repository
public class EmployeeDao {

	@PersistenceContext
	EntityManager entityManger;

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeDetails() {
		return entityManger.createNamedStoredProcedureQuery("firstProcedure").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeByCategory(String category) {
		return entityManger.createNamedStoredProcedureQuery("secondProcedure").setParameter("tcategory", category)
				.getResultList();
	}
}