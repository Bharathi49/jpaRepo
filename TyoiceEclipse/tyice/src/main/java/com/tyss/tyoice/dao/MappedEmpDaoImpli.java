package com.tyss.tyoice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tyss.tyoice.dto.Employee;
import com.tyss.tyoice.dto.MappedEmployess;

@Repository
public class MappedEmpDaoImpli implements MappedProjectDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean insertMapEmp(MappedEmployess mapEmp) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(mapEmp);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			manager.close();
			return false;
		}
	}

	@Override
	public List<MappedEmployess> getAllMapProj() {
		EntityManager manager = factory.createEntityManager();
		String get = "from MappedEmployess";
		Query<MappedEmployess> query = (Query<MappedEmployess>) manager.createQuery(get);
		List<MappedEmployess> list = query.getResultList();
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

	@Override
	public MappedEmployess getProjByEmpId(int empId) {
		EntityManager manager = factory.createEntityManager();
		String get = "from MappedEmployess where empId =: empId";
		Query query = (Query) manager.createQuery(get);
		query.setParameter("empId", empId);
		MappedEmployess emps = (MappedEmployess) query.getSingleResult();
		if (emps != null) {
			return emps;
		}
		return null;
	}

}
