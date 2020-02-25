package com.tyss.ehub.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class EmployeeResponse {

	private int statusCode;
	private String message;
	private int id;
	private Employee employee;
	private HashSet<String> list;
	Map<String, Integer> countMap;
	private Set<Integer> expList;
	Map<Integer, Integer> countexpi;
	private List<Object> countPayment;
	private List<Employee> empList;
}
