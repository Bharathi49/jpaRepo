package com.tyss.tyoice.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tyss.tyoice.dto.ClientProject;
import com.tyss.tyoice.dto.Employee;

public interface EmployeeDao {

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

	List<Employee> getAllEmps();

	public boolean updateOnMapProj(Employee employee,int proId);
	
	public List<ClientProject> getbyProjectId(int projId);

	public List<Employee> getEmpsByProjId(int pId); 
	
}
