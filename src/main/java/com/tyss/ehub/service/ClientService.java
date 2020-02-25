package com.tyss.ehub.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tyss.ehub.dto.ClientsInfo;
import com.tyss.ehub.dto.ClientsInfoResponse;

public interface ClientService {

	public boolean insert(ClientsInfo clientinfo);

	public boolean delete(int bid);

	public boolean update(ClientsInfo clientinfo);

	public List<ClientsInfo> getAllClients();

	public Map<Integer, Integer> getCountBillable();
	
	public ClientsInfoResponse getClientDeatils(int id);

	public Map<String, Integer> getStackCount(int clientId);

	public Set<String> getStackUnique(int clientId);

	public ClientsInfoResponse getYearSet(int clientId);
	
	public ClientsInfoResponse getExpAndFreshDeatails();

}
