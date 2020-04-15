package com.tyss.tyoice.dao;

import java.util.List;

import com.tyss.tyoice.dto.ClientProject;
import com.tyss.tyoice.dto.Employee;

public interface ClientProjectDao {

	public ClientProject addClientProject(ClientProject cliProject);

	public List<ClientProject> getAllCliProjects();

	public List<Employee> getEmpsByProjId(int pId);
}
