package com.tyss.tyoice.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class PackageResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<PackageBillable> listPackageBillables;
	Map<Integer, Double> revenuMap;
	Map<Integer, Integer> empMap;
    HashSet<Integer> yearList;
    private Double profit;
	
}
