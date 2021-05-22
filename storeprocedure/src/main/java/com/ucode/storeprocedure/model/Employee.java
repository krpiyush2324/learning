package com.ucode.storeprocedure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "firstProcedure", procedureName = "getEmployeeList"),
		@NamedStoredProcedureQuery(name = "secondProcedure", procedureName = "employeeByCategory", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tcategory", type = String.class) }) })
public class Employee {

	@Id
	private int id;
	private String name;
	private String category;
	private String salary;

}
