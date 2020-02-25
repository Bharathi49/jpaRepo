package com.tyss.ehub.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table
public class Billable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int employeeId;
	
	@Column
	@Size(min = 3, max = 15, message = "employee name must be between 3 and 15 characters")
	private String empName;
	
	@Column
	@FutureOrPresent		//excluding today's date
	private Date deployementDate;
	
	@Column
	@FutureOrPresent
	private Date contractEndDate;
	
	@Column
	private double rateCardPerMonth;
	
	@Column
	@Size(max = 30, min = 6, message = "stack must be between 6 to 30 characters")
	private String stack;
	
	@Column
	@PositiveOrZero
	@Max(value = 25, message = "Year Of Experience should not be greater than 25")
	private int yoe;
	
	@Column
	private int compId;

}
