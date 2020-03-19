package com.testyantra.tyssEhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.tyssEhub.dto.EmployeeDetails;
import com.testyantra.tyssEhub.dto.JsonResponse;
import com.testyantra.tyssEhub.service.EmployeeDetailsService;


@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class EmployeeDetailsController {
	@Autowired
	private EmployeeDetailsService service;

	

	@PostMapping(path = "/addEmployeeDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse addEmpDetails(@RequestBody EmployeeDetails empDetails) {
		JsonResponse response = new JsonResponse();
		EmployeeDetails employee = service.addEmpDeatils(empDetails);

		if (employee != null) {
			response.setError(false);
			response.setEmpDetail(employee);
		} else {

			response.setError(true);
			response.setMessage("failed to add data into DB");
		}
		return response;

	}

	@GetMapping(path = "/getEmployeeDetailByName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse getEmpDetails(@PathVariable("userName") String userName) {
		JsonResponse response = new JsonResponse();
		List<EmployeeDetails> list = service.findByName(userName);

		if (list != null) {
			response.setError(false);
			response.setEmpDetails(list);
		} else {

			response.setError(true);
			response.setMessage("failed to found employee Details");
		}
		return response;

	}

	@GetMapping(path = "/getAllEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse getAllEmpDetails(EmployeeDetails details) {
		JsonResponse response = new JsonResponse();
		List<EmployeeDetails> list = service.getAllEmployee(details);

		if (list != null) {
			response.setError(false);
			response.setEmpDetails(list);
		} else {

			response.setError(true);
			response.setMessage("failed to found employee Details");
		}
		return response;

	}
}
