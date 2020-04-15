package com.tyss.tyoice.dao;

import java.util.List;

import com.tyss.tyoice.dto.PackageBillable;
import com.tyss.tyoice.dto.PackageResponse;

public interface PackageDao {

	public boolean addPackage(PackageBillable pakg);

	public boolean updatePackage(PackageBillable pakg);

	public List<PackageBillable> getAllPackage();

	public boolean removePackage(int eId);

	public PackageResponse getRevenuDeatils();
	
	public Double overAllProfit();
	
	public PackageResponse yearWiseEmpMap();

}