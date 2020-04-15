package com.tyss.tyoice.controller;

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

import com.tyss.tyoice.dto.Employee;
import com.tyss.tyoice.dto.JsonResponse;
import com.tyss.tyoice.service.EmployeeService;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "*")
@RequestMapping("/employee")
@ValidateOnExecution
public class EmployeeControler {

	@Autowired
	EmployeeService service;

	@PostMapping(path = "/employee")
	public JsonResponse addEmp(@Valid @RequestBody Employee employee) {
		JsonResponse response = new JsonResponse();
		Employee employee2=service.insertEmp(employee);
		if (employee2!=null) {
			response.setError(false);
			response.setData(employee.getEmpId());
		} else {
			response.setError(true);
			response.setMessage("Failed to add employee");
		}
		return response;
	}

//	@GetMapping(path = "/employeetech")
//	public JsonResponse getAllEmp() {
//		JsonResponse response = new JsonResponse();
//		HashSet<String> list = service.getAllEmployee();
//		if (list != null) {
//			response.setError(false);
//			response.setData(list);
//		} else {
//			response.setError(true);
//			response.setMessage("Failed to add employee");
//		}
//		return response;
//	}
//
//	@PutMapping(path = "/employee")
//	public JsonResponse updateEmp(@Valid @RequestBody Employee employee) {
//		JsonResponse response = new JsonResponse();
//		if (service.updateEmp(employee)) {
//			response.setError(false);
//			response.setData(employee);
//		} else {
//			response.setError(true);
//			response.setMessage("Failed to add employee");
//		}
//		return response;
//	}
//
//	@DeleteMapping(path = "/employee/{eId}")
//	public JsonResponse deleteEmp(@PathVariable int eId) {
//		JsonResponse response = new JsonResponse();
//		if (service.deleteEmp(eId)) {
//			response.setError(false);
//			response.setData(eId);
//		} else {
//			response.setError(true);
//			response.setMessage("Failed to add employee");
//		}
//		return response;
//	}
//
	@GetMapping(path = "/employee/{id}")
	public JsonResponse getEmpById(@PathVariable int id) {
		JsonResponse response = new JsonResponse();
		Employee employee = service.getEmp(id);
		if (employee != null) {
			response.setError(false);
			response.setData(employee);
		} else {
			response.setError(true);
			response.setMessage("Failed to add employee");
		}
		return response;
	}
//
//	@GetMapping(path = "/stackCountMap", produces = MediaType.APPLICATION_JSON_VALUE)
//	public JsonResponse getStackMap() {
//		JsonResponse response = new JsonResponse();
//		Map<String, Integer> countMap = service.getStackCount();
//		if (countMap == null) {
//			response.setError(true);
//			response.setMessage("Failed to add employee");
//		} else {
//			response.setError(false);
//			response.setData(countMap);
//		}
//		return response;
//	}
//
//	@GetMapping(path = "/getnonbillexpi", produces = MediaType.APPLICATION_JSON_VALUE)
//	public JsonResponse getExperience() {
//		JsonResponse response = new JsonResponse();
//		Set<Integer> list = service.getNonBillExperinceList();
//		if (list == null) {
//			response.setError(true);
//			response.setMessage("Failed to add employee");
//		} else {
//			response.setError(false);
//			response.setData(list);
//		}
//		return response;
//	}
//
//	@GetMapping(path = "/nonBillexpCount", produces = MediaType.APPLICATION_JSON_VALUE)
//	public JsonResponse map() {
//		JsonResponse response = new JsonResponse();
//		Map<Integer, Integer> map1 = service.getNonBillExpCount();
//		if (map1 == null) {
//			response.setError(true);
//			response.setMessage("Failed to add employee");
//		} else {
//			response.setError(false);
//			response.setData(map1);
//		}
//		return response;
//	}
//
//	@GetMapping(path = "/countpayement", produces = MediaType.APPLICATION_JSON_VALUE)
//	public JsonResponse getPaymentCount() {
//		JsonResponse response = new JsonResponse();
//		List<Object> map1 = service.getCountPaymentType();
//		if (map1 == null) {
//			response.setError(true);
//			response.setMessage("Failed to add employee");
//		} else {
//			response.setError(false);
//			response.setData(map1);
//		}
//		return response;
//	}
//
//	@GetMapping(path = "/getByTech/{tech}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public JsonResponse getByTechnology(@PathVariable String tech) {
//		JsonResponse response = new JsonResponse();
//		List<Employee> techList = service.getByTechno(tech);
//		if (techList == null) {
//			response.setError(true);
//			response.setMessage("Failed to add employee");
//		} else {
//			response.setError(false);
//			response.setData(techList);
//		}
//		return response;
//	}
//
	@GetMapping(path = "/emps")
	public JsonResponse getAllEmps() {
		JsonResponse response = new JsonResponse();
		List<Employee> list = service.getAllEmps();
		if (list != null) {
			response.setError(false);
			response.setData(list);
		} else {
			response.setError(true);
			response.setMessage("Failed to fetch employees");
		}
		return response;
	}
	
	@GetMapping(path = "/getempbypid/{pId}")
	public JsonResponse getEmpByProId(@PathVariable int pId) {
		JsonResponse response = new JsonResponse();
		List<Employee> list = service.getEmpsByProjId(pId);
		if (list != null) {
			response.setError(false);
			response.setData(list);
		} else {
			response.setError(true);
			response.setMessage("not able to fetch");
		}
		return response;
	}
}
