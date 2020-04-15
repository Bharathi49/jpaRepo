package com.tyss.tyoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tyoice.dao.ClientProjectDao;
import com.tyss.tyoice.dto.ClientProject;
import com.tyss.tyoice.dto.Employee;

@Service
public class ClientProjectServiceImpli implements ClientProjectService{

	@Autowired
	ClientProjectDao dao;
	
	@Override
	public ClientProject addClientProject(ClientProject cliProject) {
		return dao.addClientProject(cliProject);
	}

	@Override
	public List<ClientProject> getAllCliProjects() {
		return dao.getAllCliProjects();
	}

	@Override
	public List<Employee> getEmpsByProjId(int pId) {
		return dao.getEmpsByProjId(pId);
	}

}
