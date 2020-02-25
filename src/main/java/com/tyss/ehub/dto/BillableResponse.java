package com.tyss.ehub.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class BillableResponse {
	private int statusCode;
	private String message;
	private String description;
	private Billable empBill;
	private Set<String> listBill;
	private List<Billable> billList;
	Map<String, Integer> countMap;
	private Set<Integer> expList;
	Map<Integer, Integer> countexpi;
	private Set<Billable> techSet;
}
