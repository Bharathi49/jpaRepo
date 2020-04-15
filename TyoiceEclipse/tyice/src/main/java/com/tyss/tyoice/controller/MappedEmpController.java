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

import com.tyss.tyoice.dto.Employee;
import com.tyss.tyoice.dto.JsonResponse;
import com.tyss.tyoice.dto.MappedEmployess;
import com.tyss.tyoice.service.EmployeeService;
import com.tyss.tyoice.service.MappedEmpService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/mapproject")
public class MappedEmpController {

	@Autowired
	MappedEmpService service;
	@Autowired
	EmployeeService empService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@PostMapping(path = "/mapproject", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse createCandidates(@RequestParam String clientEmail, @RequestParam String billableType,
			@RequestParam Date startDate, @RequestParam int empId, @RequestParam int projectId,
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
		Employee employee = empService.getEmp(empId);
		empService.updateOnMapProj(employee.getEmpName(), employee.getTechnology(), employee.getDept(), employee.getEmpEmail(),
				employee.getEmpPhNumber(), employee.getYoe(), employee.getLocation(),  employee.getPaymentType(), projectId,
				employee.getEmpId());
		MappedEmployess candidate = new MappedEmployess();
		candidate.setClientEmail(clientEmail);
		candidate.setBillableType(billableType);
		candidate.setEmpId(empId);
		candidate.setStartDate(startDate);
		candidate.setPoDoc(confile1);
		candidate.setSowDoc(confile2);
		candidate.setWoDoc(confile3);
		candidate.setProjId(projectId);
		if (!service.insertMapEmp(candidate)) {
			response.setError(true);
			response.setMessage("not able to register");
		} else {

			response.setError(false);
			response.setData(candidate.getMapEmpId());
		}
		return response;
	}

	@GetMapping(path = "/mapproject")
	public JsonResponse getAllClientProject() {
		JsonResponse response = new JsonResponse();
		List<MappedEmployess> list = service.getAllMapProj();
		if (list != null) {
			response.setError(false);
			response.setData(list);
		} else {
			response.setError(true);
			response.setMessage("not able to fetch");
		}
		return response;
	}

	@GetMapping(path = "/mapproject/{empId}")
	public JsonResponse getProj(@PathVariable int empId) {
		JsonResponse response = new JsonResponse();
		MappedEmployess list = service.getProjByEmpId(empId);
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
