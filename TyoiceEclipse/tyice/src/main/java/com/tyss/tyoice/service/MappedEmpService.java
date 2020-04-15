package com.tyss.tyoice.service;

import java.util.List;

import com.tyss.tyoice.dto.MappedEmployess;

public interface MappedEmpService {

	public boolean insertMapEmp(MappedEmployess mapEmp);
	
	public List<MappedEmployess> getAllMapProj();

	MappedEmployess getProjByEmpId(int empId);
	
}
