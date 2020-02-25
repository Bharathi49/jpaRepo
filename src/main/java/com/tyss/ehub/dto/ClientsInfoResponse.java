package com.tyss.ehub.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class ClientsInfoResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<ClientsInfo> listclients;
	private List<Billable> listBill;
	private ClientsInfo client;
	Map<Integer, Integer> countMap;
	Map<Integer, Integer> fretMap;
	Map<Integer, Integer> expCount;
	private Billable billable;
	Map<String, Integer> stackMap;
	Set<String> stackUniq;
	Set<Integer> yearList;
}
