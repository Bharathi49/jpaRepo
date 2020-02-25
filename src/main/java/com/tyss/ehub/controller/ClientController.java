package com.tyss.ehub.controller;

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

import com.tyss.ehub.dto.ClientsInfo;
import com.tyss.ehub.dto.ClientsInfoResponse;
import com.tyss.ehub.service.ClientService;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "*")
@RequestMapping("/clientinfo")
@ValidateOnExecution
public class ClientController {

	@Autowired
	private ClientService service;

	@PostMapping(path = "/clientinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse addclientsinfo(@Valid @RequestBody ClientsInfo clientsInfo) {
		ClientsInfoResponse response = new ClientsInfoResponse();
		if (service.insert(clientsInfo)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully stored..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
		}
		return response;
	}

	@DeleteMapping(path = "/clientinfo/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse deleteclient(@PathVariable("clientId") int clientId) {
		ClientsInfoResponse response = new ClientsInfoResponse();
		if (service.delete(clientId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully deleted..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully deleted..");
		}
		return response;
	}

	@GetMapping(path = "/clientinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse getAll() {
		ClientsInfoResponse response = new ClientsInfoResponse();
		List<ClientsInfo> list = service.getAllClients();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived");
			response.setListclients(list);
		}
		return response;
	}

	@PutMapping(path = "/clientinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse updateclient(@RequestBody ClientsInfo cinfo) {
		ClientsInfoResponse response = new ClientsInfoResponse();
		if (service.update(cinfo)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully updated..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully updated..");
		}
		return response;
	}

	@GetMapping(path = "/getcount", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse getBillCount() {
		ClientsInfoResponse response = new ClientsInfoResponse();
		Map<Integer, Integer> info = service.getCountBillable();
		if (info != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully getting..");
			response.setCountMap(info);
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully getting..");
		}
		return response;
	}

	@GetMapping(path = "/getStackDetails/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse getClientDetails(@PathVariable("clientId") int clientId) {
		ClientsInfoResponse response = service.getClientDeatils(clientId);
		if (response != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		}
		return response;
	}

	@GetMapping(path = "/getStackCount/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse getStackDeatils(@PathVariable("clientId") int clientId) {
		ClientsInfoResponse response = new ClientsInfoResponse();
		Map<String, Integer> stackMap = service.getStackCount(clientId);
		response.setStackMap(stackMap);
		if (stackMap != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		}
		return response;
	}

	@GetMapping(path = "/getUniqueStack/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse getUniqueStack(@PathVariable("clientId") int clientId) {
		ClientsInfoResponse response = new ClientsInfoResponse();
		Set<String> stackData = service.getStackUnique(clientId);
		if (stackData != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived..");
			response.setStackUniq(stackData);
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		}
		return response;
	}

	@GetMapping(path = "/getYearList/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse getEmpExpYearsWise(@PathVariable("clientId") int clientId) {
		ClientsInfoResponse response = new ClientsInfoResponse();
		response = service.getYearSet(clientId);
		if (response != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived..");

		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		}
		return response;
	}

	@GetMapping(path = "/getFreshExpDeatails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoResponse getEmpExpYearsWise() {
		ClientsInfoResponse response = new ClientsInfoResponse();
		response = service.getExpAndFreshDeatails();
		if (response != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived..");

		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		}
		return response;
	}

}
