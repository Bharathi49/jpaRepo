package com.testyantra.tyssEhub.service;

import java.util.List;

import com.testyantra.tyssEhub.dto.EmployeeDetails;

public interface EmployeeDetailsService {
	
	public EmployeeDetails addEmpDeatils(EmployeeDetails details);
	
	public List<EmployeeDetails> findByName(String userName);
	
	public List<EmployeeDetails> getAllEmployee(EmployeeDetails employee);

}
