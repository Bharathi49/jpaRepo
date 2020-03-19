package com.testyantra.tyssEhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.testyantra.tyssEhub.dto.ClientDetails;
import com.testyantra.tyssEhub.dto.ClientInfoDTO;
import com.testyantra.tyssEhub.repo.ClientInfoRepo;

@Repository
public class ClientInfoServiceImpl implements ClientInfoService {
	@Autowired
	private ClientInfoRepo clientInfoRepo;
	

	@Override
	public ClientInfoDTO addClient(ClientInfoDTO dto) {
		/*
		 * ClientInfoDTO info = new ClientInfoDTO(); dto.getClientId();
		 * info.setCfullname(dto.getCfullname());
		 * info.setCshortname(dto.getCshortname()); info.setGstin(dto.getGstin());
		 * info.setPanNo(dto.getPanNo()); info.setCin(dto.getCin());
		 * info.setNotes(dto.getNotes());
		 * 
		 * try {
		 * 
		 * ClientInfoDTO info2 = clientInfoRepo.save(info); List<ClientDetails> list =
		 * dto.getClientDetails();
		 * 
		 * for (ClientDetails clientDetails : list) { ClientDetails clDetails = new
		 * ClientDetails(); clDetails.setClientInfoDTO(info2);
		 * clDetails.setClientName(clientDetails.getClientName());
		 * clDetails.setEmail(clientDetails.getEmail());
		 * clDetails.setPhoneNumber(clientDetails.getPhoneNumber());
		 * clientDetailsRepo.save(clDetails); }
		 * 
		 * return info2; } catch (Exception e) { e.printStackTrace(); return null;
		 * 
		 * }
		 */

		/*
		 * ClientInfoDTO info = clientInfoRepo.save(dto);
		 * 
		 * return info;
		 */
		
		for(ClientDetails cd : dto.getClientDetails()) {
			cd.setClientInfoDTO(dto);
		}
		
	return	clientInfoRepo.save(dto);
	}

	@Override
	public List<ClientInfoDTO> getALlClients() {

		return clientInfoRepo.findAll();

	}

	@Override
	public List<ClientInfoDTO> getByName(String cfullname) {
		List<ClientInfoDTO> byName = clientInfoRepo.findByName(cfullname);
		return byName;
	}

}
