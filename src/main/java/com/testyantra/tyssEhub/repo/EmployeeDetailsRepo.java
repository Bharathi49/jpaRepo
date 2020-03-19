package com.testyantra.tyssEhub.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.testyantra.tyssEhub.dto.EmployeeDetails;

public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer>{
	@Query("from EmployeeDetails where userName=:userName ")
	public List<EmployeeDetails> findByName(String userName);

}
