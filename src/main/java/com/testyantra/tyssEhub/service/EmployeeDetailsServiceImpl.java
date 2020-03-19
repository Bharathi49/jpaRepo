package com.testyantra.tyssEhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.tyssEhub.dto.EmployeeDetails;
import com.testyantra.tyssEhub.repo.EmployeeDetailsRepo;
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	
	@Autowired
	private EmployeeDetailsRepo empRepo;

	@Override
	public EmployeeDetails addEmpDeatils(EmployeeDetails details) {
		
		EmployeeDetails employee=empRepo.save(details);
		
		return employee;
	}

	@Override
	public List<EmployeeDetails> findByName(String userName) {
		List<EmployeeDetails> details=empRepo.findByName(userName);
		return details;
	}

	@Override
	public List<EmployeeDetails> getAllEmployee(EmployeeDetails employee) {
		
		return empRepo.findAll();
	}

}
