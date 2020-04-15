package com.tyss.tyoice.dao;

import java.util.List;

import com.tyss.tyoice.dto.Employee;
import com.tyss.tyoice.dto.MappedEmployess;

public interface MappedProjectDao {

	public boolean insertMapEmp(MappedEmployess mapEmp);

	public List<MappedEmployess> getAllMapProj();

	public List<Employee> getEmpsByProjId(int pId);

	public MappedEmployess getProjByEmpId(int empId);
}
