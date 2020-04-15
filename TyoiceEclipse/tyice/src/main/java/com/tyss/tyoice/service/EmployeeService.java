package com.tyss.tyoice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tyss.tyoice.dto.ClientProject;
import com.tyss.tyoice.dto.Employee;

public interface EmployeeService {

	public Employee insertEmp(Employee employee);

//	public boolean deleteEmp(int id);
//
//	public HashSet<String> getAllEmployee();
//	
	public Employee getEmp(int eId);

//
//	public boolean updateEmp(Employee employee);
//
//	public Set<Integer> getNonBillExperinceList();
//
//	public Map<Integer, Integer> getNonBillExpCount();
//
//	public Map<String, Integer> getStackCount();
//
//	public List<Object> getCountPaymentType();
//	
//	public List<Employee> getByTechno(String techno);
//	
	public List<Employee> getEmpsByProjId(int pId);
	
	public List<Employee> getAllEmps();

	public int updateOnMapProj(String empName, String technology, String dept, String empEmail, String empPhNumber,
			int yoe, String location, String paymentType, int projId, int empId);
//
//	public List<ClientProject> getbyProjectId(int projId);
//
//	public List<Employee> getEmpsByProjId(int pId); 
}
