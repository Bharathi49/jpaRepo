package com.tyss.ehub.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Entity
@Table
@Data
public class ClientsInfo implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue
	private int clientId;
	
	@Column
	@Size(min = 40 , max = 80, message = "Client name must be between 40 and 80 characters")
	private String clientName;
	
	@Column
	@Size(min = 3, max = 6, message = "Client Short Name must be between 3 to 6 character")
	private String clienShortName;
	
	@Column
	@Size(min = 8, max = 30, message = "Department name must be between 8 to 30 characters")
	private String deptName;
	
	@Column
	@Pattern(regexp="(^$|[0-9]{10})")
	private String clientNo;
	
	@Email
	@Column
	private String clientEmail;
	
	@Column
	private String compWebSite;
	
	@Lob
	private String clientLogo; 					// image storing
	
	@Column
	@Size(min = 10 , max = 100, message = "street name must be between 10 to 100 characters")
	private String streetAddress;
	
	@Column
	@Size(min = 10 , max = 50, message = "address must be between 10 to 50 characters")
	private String addressLine2;
	
	@Column
	@Size(min = 5 , max = 50, message = "city name must be between 10 to 50 characters")
	private String city;
	
	@Column
	@Size(min = 5 , max = 50, message = "state name must be between 10 to 100 characters")
	private String state;
	
	@Column
	@Min( value = 560000, message = "zipcode must contain 6 digits")
	@Max( value = 599999, message = "zipcode must contain 6 digits")
	private int zipCode;
	
	@Column
	private String country;
	
}
