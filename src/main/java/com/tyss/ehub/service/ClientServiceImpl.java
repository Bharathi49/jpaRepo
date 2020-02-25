package com.tyss.ehub.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.ehub.dao.Clientdao;
import com.tyss.ehub.dto.ClientsInfo;
import com.tyss.ehub.dto.ClientsInfoResponse;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private Clientdao dao;

	@Override
	public boolean insert(ClientsInfo clientinfo) {
		return dao.insert(clientinfo);
	}

	@Override
	public boolean delete(int bid) {
		return dao.delete(bid);
	}

	@Override
	public boolean update(ClientsInfo clientinfo) {
		return dao.update(clientinfo);
	}

	@Override
	public List<ClientsInfo> getAllClients() {
		return dao.getAllClients();
	}

	@Override
	public Map<Integer, Integer> getCountBillable() {
		return dao.getCountBillable();
	}

	@Override
	public ClientsInfoResponse getClientDeatils(int id) {
		return dao.getClientDeatils(id);
	}

	@Override
	public Map<String, Integer> getStackCount(int clientId) {

		return dao.getStackCount(clientId);
	}

	@Override
	public Set<String> getStackUnique(int clientId) {
		return dao.getStackUnique(clientId);
	}

	@Override
	public ClientsInfoResponse getYearSet(int clientId) {
		return dao.getYearSet(clientId);
	}

	public ClientsInfoResponse getExpAndFreshDeatails() {
		return dao.getExpAndFreshDeatails();
	}

}
