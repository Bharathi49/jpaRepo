package com.tyss.tyoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tyoice.dao.PackageDao;
import com.tyss.tyoice.dto.PackageBillable;
import com.tyss.tyoice.dto.PackageResponse;
@Service
public class PackageServiceImpli implements PackageBillableService{

	@Autowired
	private PackageDao dao;

	@Override
	public boolean addPackage(PackageBillable pakg) {
		return dao.addPackage(pakg);
	}

	@Override
	public boolean updatePackage(PackageBillable pakg) {
		return dao.updatePackage(pakg);
	}

	@Override
	public List<PackageBillable> getAllPackage() {
		return dao.getAllPackage();
	}

	@Override
	public boolean removePackage(int pakgId) {
		return dao.removePackage(pakgId);
	}

	@Override
	public PackageResponse getRevenuList() {
		
		return dao.getRevenuDeatils();
	}
	
	public Double profit() {
		
		return dao.overAllProfit();
	}

	@Override
	public PackageResponse yearWiseEmpMap() {
		
		return dao.yearWiseEmpMap();
	}

}
