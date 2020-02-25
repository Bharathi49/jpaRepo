package com.tyss.ehub.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.ehub.dto.Employee;
import com.tyss.ehub.dto.EmployeeResponse;
import com.tyss.ehub.service.EmployeeService;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "*")
@RequestMapping("/employee")
@ValidateOnExecution
public class EmployeeControler {

	@Autowired
	EmployeeService service;

	@PostMapping(path = "/employee")
	public EmployeeResponse addEmp(@Valid @RequestBody Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.insertEmp(employee)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setId(employee.getEmpId());
		} else {
			response.setStatusCode(400);
			response.setMessage("Failure");
		}
		return response;
	}

	@GetMapping(path = "/employee")
	public EmployeeResponse getAllEmp() {
		EmployeeResponse response = new EmployeeResponse();
		HashSet<String> list = service.getAllEmployee();
		if (list != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setList(list);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failure");
		}
		return response;
	}

	@PutMapping(path = "/employee")
	public EmployeeResponse updateEmp(@Valid @RequestBody Employee employee) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.updateEmp(employee)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setEmployee(employee);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failure");
		}
		return response;
	}

	@DeleteMapping(path = "/employee/{eId}")
	public EmployeeResponse deleteEmp(@PathVariable int eId) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.deleteEmp(eId)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setId(eId);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failure");
		}
		return response;
	}
	
	@GetMapping(path = "/employee/{id}")
	public EmployeeResponse getEmp(@PathVariable int id) {
		EmployeeResponse response = new EmployeeResponse();
		Employee employee = service.getEmp(id);
		if(employee != null) {
			response.setStatusCode(200);
			response.setEmployee(employee);
		}else {
			response.setStatusCode(400);
			response.setMessage("Failure");
		}
		return response;
	}
	
	@GetMapping(path = "/stackCountMap", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getStackMap() {
		EmployeeResponse response = new EmployeeResponse();
		Map<String, Integer> countMap = service.getStackCount();
		response.setCountMap(countMap);
		if (countMap == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
		}
		return response;
	}

	@GetMapping(path = "/getnonbillexpi", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getExperience() {
		EmployeeResponse response = new EmployeeResponse();
		Set<Integer> list = service.getNonBillExperinceList();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setExpList(list);
		}
		return response;
	}

	@GetMapping(path = "/nonBillexpCount", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse map() {
		EmployeeResponse response = new EmployeeResponse();
		Map<Integer, Integer> map1 = service.getNonBillExpCount();
		if (map1 == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setCountexpi(map1);
		}
		return response;
	}
	
	@GetMapping(path = "/countpayement", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getPaymentCount() {
		EmployeeResponse response = new EmployeeResponse();
		List<Object> map1 = service.getCountPaymentType();
		if (map1 == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setCountPayment(map1);
		}
		return response;
	}

	@GetMapping(path = "/getByTech/{tech}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getByTechnology(@PathVariable String tech) {
		EmployeeResponse response = new EmployeeResponse();
		List<Employee> techList = service.getByTechno(tech);
		if (techList == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setEmpList(techList);
		}
		return response;
	}

}
