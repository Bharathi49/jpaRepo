package com.tyss.tyoice.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.tyoice.dto.ClientProject;
import com.tyss.tyoice.dto.Employee;
import com.tyss.tyoice.dto.JsonResponse;
import com.tyss.tyoice.service.ClientProjectService;
import com.tyss.tyoice.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/clientproject")
public class ProjectController {

	@Autowired
	ClientProjectService service;

	@Autowired
	EmployeeService empService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@PostMapping(path = "/clientproject", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse createCandidates(@RequestParam String billableType, @RequestParam String clientEmail,
			@RequestParam Date startDate, @RequestParam int empId, @RequestParam int projId,
			@RequestParam("poDoc") MultipartFile file1, @RequestParam("sowDoc") MultipartFile file2,
			@RequestParam("woDoc") MultipartFile file3) throws IOException {
		JsonResponse response = new JsonResponse();
		File confile1 = new File(file1.getOriginalFilename());
		File confile2 = new File(file2.getOriginalFilename());
		File confile3 = new File(file3.getOriginalFilename());
		FileOutputStream fout1 = new FileOutputStream(confile1);
		FileOutputStream fout2 = new FileOutputStream(confile2);
		FileOutputStream fout3 = new FileOutputStream(confile3);
		fout1.write(file1.getBytes());
		fout2.write(file2.getBytes());
		fout3.write(file3.getBytes());
		fout1.close();
		fout2.close();
		fout3.close();
		ClientProject candidate = new ClientProject();
//		Employee employee1 = empService.getEmp(empId);
		candidate.setClientEmail(clientEmail);
		candidate.setBillableType(billableType);
		candidate.setEmpId(empId);
		candidate.setProjId(projId);
		candidate.setStartDate(startDate);
		candidate.setPoDoc(confile1);
		candidate.setSowDoc(confile2);
		candidate.setWoDoc(confile3);
		ClientProject can = service.addClientProject(candidate);
//		if (employee1.getEmpId() != 0) {
////			empService.updateOnMapProj(employee1, projId);
//		}
		if (can != null) {
			response.setError(false);
			response.setData(can);
		} else {
			response.setError(true);
			response.setMessage("not able to register");
		}
		return response;
	}

	@GetMapping(path = "/clientproject")
	public JsonResponse getAllClientProject() {
		JsonResponse response = new JsonResponse();
		List<ClientProject> list = service.getAllCliProjects();
		if (list != null) {
			response.setError(false);
			response.setData(list);
		} else {
			response.setError(true);
			response.setMessage("not able to fetch");
		}
		return response;
	}

	@GetMapping(path = "/clientproject/{pId}")
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
