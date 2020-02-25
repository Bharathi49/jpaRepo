package com.tyss.ehub.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tyss.ehub.dto.Billable;

public interface Billabledao {
	
	public boolean insert(Billable bill);

	public boolean delete(int bId);

	public boolean update(Billable empBill);

	public List<Billable> getAllBillable();
	
	public Set<String> getBillable();

	public Map<String, Integer> getCountStack();

	public Set<Integer> getExperinceList();

	public Map<Integer, Integer> getExpCountMap();
	
	public List<Billable> getByTechno(String techno);
	
}
