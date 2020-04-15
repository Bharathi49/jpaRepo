package com.tyss.tyoice.service;

import java.util.List;

import com.tyss.tyoice.dto.PackageBillable;
import com.tyss.tyoice.dto.PackageResponse;

public interface PackageBillableService {

	public boolean addPackage(PackageBillable pakg);

	public boolean updatePackage(PackageBillable pakg);

	public List<PackageBillable> getAllPackage();

	public boolean removePackage(int pakgId);

	public PackageResponse getRevenuList();
	
	public Double profit();
	
	public PackageResponse yearWiseEmpMap();
}
