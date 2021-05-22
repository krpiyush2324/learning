package com.ucode.criteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ucode.criteria.model.Employee;
import com.ucode.criteria.specification.EmployeeSpecification;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeCustomRepository,JpaSpecificationExecutor<Employee>{

}
