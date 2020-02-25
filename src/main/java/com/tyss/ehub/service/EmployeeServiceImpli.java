package com.tyss.ehub.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.ehub.dao.EmployeeDao;
import com.tyss.ehub.dto.Employee;

@Service
public class EmployeeServiceImpli implements EmployeeService{

	
	@Autowired
	EmployeeDao dao;
	
	@Override
	public boolean insertEmp(Employee employee) {
		return dao.insertEmp(employee);
	}

	@Override
	public boolean deleteEmp(int id) {
		return dao.deleteEmp(id);
	}

	@Override
	public HashSet<String> getAllEmployee() {
		return dao.getAllEmployee();
	}

	@Override
	public boolean updateEmp(Employee employee) {
		return dao.updateEmp(employee);
	}

	@Override
	public Employee getEmp(int eId) {
		return dao.getEmp(eId);
	}

	@Override
	public Set<Integer> getNonBillExperinceList() {
		return dao.getNonBillExperinceList();
	}

	@Override
	public Map<Integer, Integer> getNonBillExpCount() {
		return dao.getNonBillExpCount();
	}

	@Override
	public Map<String, Integer> getStackCount() {
		return dao.getStackCount();
	}

	@Override
	public List<Object> getCountPaymentType() {
		return dao.getCountPaymentType();
	}

	@Override
	public List<Employee> getByTechno(String techno) {
		return dao.getByTechno(techno);
	}

}
