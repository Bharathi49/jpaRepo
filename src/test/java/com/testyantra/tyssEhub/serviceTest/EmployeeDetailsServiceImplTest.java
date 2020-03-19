package com.testyantra.tyssEhub.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.testyantra.tyssEhub.dto.EmployeeDetails;
import com.testyantra.tyssEhub.exception.TestException;
import com.testyantra.tyssEhub.service.EmployeeDetailsService;

class EmployeeDetailsServiceImplTest {
	
	@Autowired
	EmployeeDetailsService service;

	@Test
	void test() {
		fail("Not yet implemented");
	}
   @Test
	void addEmployeeTest() {
		
		EmployeeDetails employee=new EmployeeDetails();
		employee.setProfile_ID(101);
		employee.setEmployeeType("full time");
		employee.setUserName("kiran");
		employee.setFullName("kiran kumar");
		employee.setSlNo(1);
		employee.setMobileNo("9916903314");
		employee.setOurBussinessUnit("outsource");
		employee.setPan("GEGPK0120H");
		employee.setTyEmployeeID("10");
		
		
try {
			
			EmployeeDetails dto=service.addEmpDeatils(employee);
			assertEquals(dto, true);
		}catch (Exception e) {
			assertThrows(TestException.class, ()->{
				service.addEmpDeatils(employee);
			});
		}
	}
   
   @Test
   void testRetrive() {
	   
	   EmployeeDetails employee=new EmployeeDetails();
		employee.setProfile_ID(101);
		employee.setEmployeeType("full time");
		employee.setUserName("kiran");
		employee.setFullName("kiran kumar");
		employee.setSlNo(1);
		employee.setMobileNo("9916903314");
		employee.setOurBussinessUnit("outsource");
		employee.setPan("GEGPK0120H");
		employee.setTyEmployeeID("10");
	   
	   assertNotNull(service.getAllEmployee(employee));
   
   }
	
}
