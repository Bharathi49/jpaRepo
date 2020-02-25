package com.tyss.ehub.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import org.hibernate.query.Query;

import org.springframework.stereotype.Repository;

import com.tyss.ehub.dto.Billable;
import com.tyss.ehub.dto.Employee;

@Repository
public class EmployeeDaoImpli implements EmployeeDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean insertEmp(Employee employee) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			manager.close();
			return false;
		}
	}

	@Override
	public boolean deleteEmp(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			transaction.begin();
			manager.remove(employee);
			transaction.commit();
			manager.close();
			return true;
		}
		return false;
	}

	@Override
	public HashSet<String> getAllEmployee() {
		HashSet<String> hs = null;
		EntityManager manager = factory.createEntityManager();
		try {
			String get = "select technology from Employee";
			Query<String> query = (Query) manager.createQuery(get);
			List<String> list = query.getResultList();
			hs = new HashSet<String>(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return hs;
	}

	@Override
	public boolean updateEmp(Employee employee) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Employee emp = manager.find(Employee.class, employee.getEmpId());
		if (emp != null) {
			transaction.begin();
			emp.setEmpId(employee.getEmpId());
			emp.setEmpName(employee.getEmpName());
			emp.setDept(employee.getDept());
			emp.setPaymentType(employee.getPaymentType());
			emp.setTechnology(employee.getTechnology());
			emp.setLocation(employee.getLocation());
			emp.setYoe(employee.getYoe());
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmp(int eId) {
		EntityManager manager = factory.createEntityManager();
		Employee employee = manager.find(Employee.class, eId);
		if (employee != null) {
			return employee;
		}
		return null;
	}

	@Override
	public Set<Integer> getNonBillExperinceList() {
		javax.persistence.Query query = null;
		List<Integer> list = null;
		HashSet<Integer> hs = null;
		EntityManager manager = factory.createEntityManager();
		try {
			String get = "select yoe from Employee";
			query = manager.createQuery(get);
			list = query.getResultList();
			hs = new HashSet<Integer>(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return hs;
	}

	@Override
	public Map<Integer, Integer> getNonBillExpCount() {
		Query<Object> queryObject = null;
		List<Object> commonlist = null;
		Iterator<Object> invItr = null;
		Object[] commonArray = null;
		Map<Integer, Integer> map = null;
		EntityManager manager = factory.createEntityManager();
		try {
			String queryString = "select yoe, count(empId) from Employee group by yoe";
			queryObject = (Query) manager.createQuery(queryString);
			commonlist = queryObject.list();
			invItr = commonlist.iterator();
			map = new HashMap<Integer, Integer>();
			while (invItr.hasNext()) {
				commonArray = (Object[]) invItr.next();
				if (commonArray[0] != null && commonArray[1] != null)
					map.put(Integer.parseInt(commonArray[0].toString()), Integer.parseInt(commonArray[1].toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		if (map == null) {
			return null;
		}
		return map;
	}

	@Override
	public Map<String, Integer> getStackCount() {
		Query<Object> queryObject = null;
		List<Object> commonlist = null;
		Iterator<Object> invItr = null;
		Object[] commonArray = null;
		Map<String, Integer> map = null;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			String queryString = "select technology, count(empId) from Employee group by technology";
			queryObject = (Query) manager.createQuery(queryString);
			commonlist = queryObject.list();
			invItr = commonlist.iterator();
			map = new HashMap<String, Integer>();
			while (invItr.hasNext()) {
				commonArray = (Object[]) invItr.next();
				if (commonArray[0] != null && commonArray[1] != null)
					map.put(commonArray[0].toString(), Integer.parseInt(commonArray[1].toString()));
				if (map == null) {
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return map;

	}

	@Override
	public List<Object> getCountPaymentType() {
		javax.persistence.Query query = null;
		List<Object> list = null;
		EntityManager manager = factory.createEntityManager();
		try {
			String get = "select paymentType, technology,count(technology) from Employee group by technology,paymentType";
			query = manager.createQuery(get);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return list;
	}

	@Override
	public List<Employee> getByTechno(String techno) {
		EntityManager manager = factory.createEntityManager();
		Employee emp = new Employee();
		List<Employee> list = null;
		try {
			String get = "from Employee where technology = : tech";
			Query query = (Query) manager.createQuery(get);
			query.setParameter("tech", techno);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return list;
	}

}
