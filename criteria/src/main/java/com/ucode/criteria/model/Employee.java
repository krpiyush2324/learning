package com.ucode.criteria.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String department;

}
