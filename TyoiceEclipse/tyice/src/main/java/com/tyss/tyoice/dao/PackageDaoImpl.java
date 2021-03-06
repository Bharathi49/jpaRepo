package com.tyss.tyoice.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.tyoice.dto.PackageBillable;
import com.tyss.tyoice.dto.PackageResponse;

@Repository
public class PackageDaoImpl implements PackageDao {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addPackage(PackageBillable pakg) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(pakg);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}
	}

	@Override
	public boolean removePackage(int pakgId) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		PackageBillable pakg = manager.find(PackageBillable.class, pakgId);
		if (pakg == null) {
			return false;
		}
		transaction.begin();
		manager.remove(pakg);
		transaction.commit();
		manager.close();
		transaction.rollback();
		return true;
	}

	@Override
	public List<PackageBillable> getAllPackage() {
		Query query = null;
		EntityManager manager = emf.createEntityManager();
		List<PackageBillable> list = null;
		try {
		String get = "from PackageBillable";
		 query = manager.createQuery(get);
		 list = query.getResultList();
		if (list != null) 
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			manager.close();
		}
		
		return list;
	}

	@Override
	public boolean updatePackage(PackageBillable pakg) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		PackageBillable pakBillable = manager.find(PackageBillable.class, pakg.getPackageId());
		if(pakBillable!=null) {
			transaction.begin();
			pakBillable.setPackageId(pakg.getPackageId());
			pakBillable.setDopByClient(pakg.getDopByClient());
			pakBillable.setDopByTy(pakg.getDopByTy());
			pakBillable.setPaymentByClient(pakg.getPaymentByClient());
			pakBillable.setPaymentByTy(pakg.getPaymentByTy());
			transaction.commit();
			return true;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return false;
	}

	@Override
	public PackageResponse getRevenuDeatils() {
		Query queryObject1 = null;
		List<Integer> commonlist = null;
		List<Object> commonlist2 = null;
		Iterator<Object> invItr = null;
		Object[] commonArray = null;
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		HashSet<Integer> yearList = null;
		PackageResponse responce = null;
		Map<Integer, Double> map = null;
		transaction.begin();
		try {
		String queryString="select year(deployementDate) from Billable";
		queryObject1 =  manager.createQuery(queryString);
		commonlist =  queryObject1.getResultList();
		responce = new PackageResponse();
		yearList = new HashSet<Integer>(commonlist);
		responce.setYearList(yearList);
		
		queryObject1 = manager.createNativeQuery("select year(deployementDate),(SUM(paymentByClient)) - (SUM(paymentByTy)) as profit from  PackageBillable p, Billable b where p.empId=b.employeeId GROUP BY year(deployementDate)");
		commonlist2 = queryObject1.getResultList();
		invItr = commonlist2.iterator();
		map = new HashMap<Integer, Double>();
		while (invItr.hasNext()) {
			commonArray = (Object[]) invItr.next();
			if (commonArray[0] != null && commonArray[1] != null)
				map.put(Integer.parseInt(commonArray[0].toString()),
						Double.parseDouble(commonArray[1].toString()));
		}
		System.out.println("revenu map is ::"+map);
		responce.setRevenuMap(map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		transaction.commit();
		return responce;
	}
	
	public PackageResponse yearWiseEmpMap() {
		Query queryObject1 = null;
		List<Object> commonlist = null;
		Iterator<Object> invItr = null;
		Object[] commonArray = null;
		EntityManager manager = emf.createEntityManager();
		Map<Integer, Integer> empMap =  null;
		PackageResponse responce = null;
		try {
			String queryString="select year(deployementDate) as year, count(employeeId) from Billable GROUP BY year(deployementDate)";
			queryObject1 =  manager.createQuery(queryString);
			commonlist =  queryObject1.getResultList();
			invItr = commonlist.iterator();
			responce = new PackageResponse();
			empMap = new HashMap<Integer, Integer>();
			while (invItr.hasNext()) {
				commonArray = (Object[]) invItr.next();
				if (commonArray[0] != null && commonArray[1] != null)
					empMap.put(Integer.parseInt(commonArray[0].toString()),
							Integer.parseInt(commonArray[1].toString()));
			}
			System.out.println("emp map in dao::"+empMap);
			responce.setEmpMap(empMap);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return responce;
	}
	
	
	public Double overAllProfit() {
		Query queryObject = null;
		EntityManager manager = emf.createEntityManager();
		Double profit = 0d;
		List<Double> commonlist = null;
		try {
			String queryString="select SUM(paymentByClient) - SUM(paymentByTy) as profit from PackageBillable";
			queryObject =  manager.createQuery(queryString);
			commonlist = queryObject.getResultList();
			if(!commonlist.isEmpty()) {
			profit = commonlist.get(0);
			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		return profit;
	}
	
}
