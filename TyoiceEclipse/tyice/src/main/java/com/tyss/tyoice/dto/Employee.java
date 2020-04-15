package com.tyss.tyoice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table
public class Employee {

	@Id
	@Column
	@GeneratedValue
	private int empId;

	@Column
	@Size(min = 3, max = 15, message = "employee name must be between 3 and 15 characters")
	private String empName;

	@Column
	@Size(min = 5, max = 30, message = "technology must be between 10 and 40 characters")
	private String technology;

	@Column
	@Size(min = 5, max = 20, message = "Department must be between 10 and 40 characters")
	private String dept;

	@Column
	@Email
	private String empEmail;

	@Column
	@Size(min = 10, max = 10, message = "Mobile number must be 10 digits")
	private String empPhNumber;

	@Column
	@PositiveOrZero
	@Max(value = 25, message = "Year of Experience should not be greater than 25")
	private int yoe;

	@Column
	@Size(min = 5, max = 40, message = "location must be between 10 and 40 characters")
	private String location;

	@Size(min = 4, max = 8, message = "location must be between 4 and 6 characters")
	@Column
	private String paymentType;

	@Column
	private int projId;

}
