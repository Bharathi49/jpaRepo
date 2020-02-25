package com.tyss.ehub.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table
public class PackageBillable {

	@Id
	@GeneratedValue
	@Column
	private int packageId;
	
	@Column
	private int compId;
	
	@Column
	private int empId;
	
	@Size(min = 3, max = 15, message = "employee name must be between 3 and 15 characters")
	@Column
	private String employeeName;
	
	@Column
	@Positive
	private double paymentByTy;
	
	@Positive
	@Column
	private double paymentByClient;
	
	@Column
	@FutureOrPresent
	private Date dopByTy;
	
	@Column
	@FutureOrPresent
	private Date dopByClient;
	
}
