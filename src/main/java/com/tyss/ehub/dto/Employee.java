package com.tyss.ehub.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@Column
	private int empId;
	
	@Column
	@Size(min = 3, max = 15, message = "employee name must be between 3 and 15 characters")
	private String empName;
	
	@Column
	@Size(min = 5 , max = 30 , message = "technology must be between 10 and 40 characters")
	private String technology;
	
	@Column
	@Size(min = 5 , max = 20 , message = "Department must be between 10 and 40 characters")
	private String dept;
	
	@Column
	@PositiveOrZero
	@Max(value = 25, message = "Year of Experience should not be greater than 25")
	private int yoe;
	
	@Column
	@Size(min = 5 , max = 40 , message = "location must be between 10 and 40 characters")
	private String location;
	
	@Size(min = 4 , max = 8 , message = "location must be between 4 and 6 characters")
	@Column
	private String paymentType;
	
}
