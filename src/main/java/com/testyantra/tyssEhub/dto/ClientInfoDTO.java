package com.testyantra.tyssEhub.dto;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "ClientInfo")
@Data
@Valid
public class ClientInfoDTO {

	@Id
	@Column(name = "client_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;
	
	@Column
	@NotBlank
	@Size(min = 6, max =80, message = "company name must be between 6 and 80 characters" )
	private String cfullname;
	@Column
    private String cshortname;
	@Column
	private String gstin;
	
	@Column
	@NotBlank
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String panNo;
	
	@Column
	@NotBlank(message = "CIN number must be mandatory")
	private String cin;
	
	@Column
	@NotBlank(message = "notes is mandatory")
	private String notes;
	
	  @OneToMany(mappedBy="clientInfoDTO",cascade = CascadeType.ALL) 
	  private List<ClientDetails> clientDetails = new ArrayList<ClientDetails>();
	 
	
	
}
