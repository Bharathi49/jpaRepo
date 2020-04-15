package com.tyss.tyoice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tyoice.dao.EmployeeDao;
import com.tyss.tyoice.dto.Employee;
import com.tyss.tyoice.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpli implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	@Autowired
	EmployeeRepo empRepo;

	@Override
	public Employee insertEmp(Employee employee) {
		Employee emp = empRepo.save(employee);
		return emp;
	}

//	@Override
//	public boolean deleteEmp(int id) {
//		return dao.deleteEmp(id);
//	}
//
//	@Override
//	public HashSet<String> getAllEmployee() {
//		return dao.getAllEmployee();
//	}
//
//	@Override
//	public boolean updateEmp(Employee employee) {
//		return dao.updateEmp(employee);
//	}
//
	@Override
	public Employee getEmp(int eId) {
		return empRepo.findByempId(eId);
	}

//
//	@Override
//	public Set<Integer> getNonBillExperinceList() {
//		return dao.getNonBillExperinceList();
//	}
//
//	@Override
//	public Map<Integer, Integer> getNonBillExpCount() {
//		return dao.getNonBillExpCount();
//	}
//
//	@Override
//	public Map<String, Integer> getStackCount() {
//		return dao.getStackCount();
//	}
//
//	@Override
//	public List<Object> getCountPaymentType() {
//		return dao.getCountPaymentType();
//	}
//
//	@Override
//	public List<Employee> getByTechno(String techno) {
//		return dao.getByTechno(techno);
//	}
//
	@Override
	public List<Employee> getAllEmps() {
		return empRepo.findAll();
	}

	@Override
	public int updateOnMapProj(String empName, String technology, String dept, String empEmail, String empPhNumber,
			int yoe, String location, String paymentType, int projId, int empId) {
		return empRepo.update(empName, technology, dept, empEmail, empPhNumber, yoe, location, paymentType, projId,
				empId);
	}
//
////	@Override
////	public List<ClientProject> getbyProjectId(int projId) {
////		return dao.getbyProjectId(projId);
////	}
//
//	@Override
//	public List<Employee> getEmpsByProjId(int pId) {
//		return dao.getEmpsByProjId(pId);
//	}

	@Override
	public List<Employee> getEmpsByProjId(int pId) {
		return empRepo.findByprojId(pId);
	}

}
