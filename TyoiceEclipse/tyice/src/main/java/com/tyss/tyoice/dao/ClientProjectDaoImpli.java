package com.tyss.tyoice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tyss.tyoice.dto.ClientProject;
import com.tyss.tyoice.dto.Employee;

@Repository
public class ClientProjectDaoImpli implements ClientProjectDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ClientProject addClientProject(ClientProject cliProject) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(cliProject);
			transaction.commit();
			return cliProject;
		} catch (Exception e) {
			e.printStackTrace();
			manager.close();
			return null;
		}

	}

	@Override
	public List<ClientProject> getAllCliProjects() {
		EntityManager manager = factory.createEntityManager();
		String get = "from ClientProject";
		Query<ClientProject> query = (Query<ClientProject>) manager.createQuery(get);
		List<ClientProject> list = query.getResultList();
		if (list != null) {
			return list;
		}
		return null;
	}

	@Override
	public List<Employee> getEmpsByProjId(int pId) {
		EntityManager manager = factory.createEntityManager();
		String get = "from Employee where projId =: pId";
		Query query = (Query) manager.createQuery(get);
		query.setParameter("pId", pId);
		List<Employee> emps = query.getResultList();
		if (emps != null) {
			return emps;
		}
		return null;
	}
}
