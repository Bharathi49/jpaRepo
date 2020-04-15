package com.tyss.tyoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tyss.tyoice.dto.Employee;

@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	public Employee findByempId(int empId);

	public List<Employee> findAll();

	public List<Employee> findByprojId(int projId);
	
	@Modifying
	@Query("update Employee set empName=:empName, technology=:technology, dept=:dept, empEmail=:empEmail, empPhNumber=:empPhNumber, yoe=:yoe, location=:location, paymentType=:paymentType, projId=:projId where empId=:empId")
	public int update(@Param("empName")String empName,@Param("technology")String technology ,@Param("dept")String dept,@Param("empEmail")String empEmail,@Param("empPhNumber")String empPhNumber,@Param("yoe")int yoe,
			@Param("location")String location,@Param("paymentType")String paymentType,@Param("projId")int projId, @Param("empId")int empId);
	
}



