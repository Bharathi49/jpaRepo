package com.tyss.tyoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tyoice.dto.MappedEmployess;
import com.tyss.tyoice.repository.MapClientProjEmpRepo;

@Service
public class MappedEmpServiceImpli implements MappedEmpService{
	
	@Autowired
	MapClientProjEmpRepo mapRepo;
	
	@Override
	public boolean insertMapEmp(MappedEmployess mapEmp) {
		MappedEmployess mapEmp1=mapRepo.save(mapEmp);
		if(mapEmp1!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<MappedEmployess> getAllMapProj() {
		return mapRepo.findAll();
	}

	@Override
	public MappedEmployess getProjByEmpId(int empId) {
		return mapRepo.findByempId(empId);
	}
}
