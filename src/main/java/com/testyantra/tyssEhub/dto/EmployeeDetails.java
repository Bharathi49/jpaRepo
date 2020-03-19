package com.testyantra.tyssEhub.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Table(name="employeeDetails")
@Data
public class EmployeeDetails {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int profile_ID;
	
	@Column
	@Version
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int slNo;
	@Column
	private String userName;
	@Column
	private String fullName;
	@Column
	private String email;
	@Column
	private String mobileNo;
	@Column
	private String tyEmployeeID;
	@Column
	private double annualCTC;
	@Column
	private String employeeType;
	@Column
	private String ourBussinessUnit;
	@Column
	private String pan;
	
	

}
