package com.testyantra.tyssEhub.dto;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.executable.ValidateOnExecution;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "clientDetails")
@Data
@ValidateOnExecution
public class ClientDetails {
	@Id
	//@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientDetailsID;
	
	//@Column
	private String clientName;
	
   //@Column
	@ElementCollection
	@CollectionTable
	//@Email
	
	private List<String> email;
	
	//@Column
	//@Pattern(regexp = "(^$|[0-9]{10})")
	@ElementCollection
	@CollectionTable
	private List<String> phoneNumber;
	
	  @JsonIgnore
	  @ManyToOne(fetch = FetchType.EAGER, optional = false)
	  @JoinColumn(name = "client_Id",referencedColumnName = "client_Id")
	  private ClientInfoDTO clientInfoDTO;
	 
}
