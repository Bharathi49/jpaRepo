package com.testyantra.tyssEhub.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.testyantra.tyssEhub.dto.ClientInfoDTO;
import com.testyantra.tyssEhub.exception.TestException;
import com.testyantra.tyssEhub.service.ClientInfoService;

class ClientInfoServiceTest {
	
	@Autowired
	ClientInfoService serviceImpl;

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void addClientInfo() {

		ClientInfoDTO info = new ClientInfoDTO();
		info.setCfullname("openText");
		info.setClientId(101);
		info.setCshortname("open");
		info.setGstin("123456789");
		info.setNotes("its a product based company");
		info.setPanNo("GEGF1023H");
		info.setCin("O45687");

		try {
			
			ClientInfoDTO dto=serviceImpl.addClient(info);
			assertEquals(dto, true);
		}catch (Exception e) {
			assertThrows(TestException.class, ()->{
				serviceImpl.addClient(info);
			});
		}

	}
	@Test 
	void testRetrive() {
		assertNotNull(serviceImpl.getALlClients());
	}


}
