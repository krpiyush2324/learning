package com.example.drooltest.model;

import lombok.Data;

@Data
public class LoanType {

	private Bridge bridge;
	private Home home;
	private Education education;
	private LoanResult loanResult;
}
