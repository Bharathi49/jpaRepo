package com.testyantra.tyssEhub.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse {
	
	private String message;
	private boolean error;
	private List<ClientInfoDTO> data;
	
	private ClientInfoDTO clientInfoDTO;
	
	private List<EmployeeDetails> empDetails;
	
	private EmployeeDetails empDetail;
	

}
