package com.tyss.ehub.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tyss.ehub.dto.Employee;

public interface EmployeeService {

	public boolean insertEmp(Employee employee);

	public boolean deleteEmp(int id);

	public HashSet<String> getAllEmployee();
	
	public Employee getEmp(int eId);

	public boolean updateEmp(Employee employee);

	public Set<Integer> getNonBillExperinceList();

	public Map<Integer, Integer> getNonBillExpCount();

	public Map<String, Integer> getStackCount();

	public List<Object> getCountPaymentType();
	
	public List<Employee> getByTechno(String techno);

}
