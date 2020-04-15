package com.tyss.tyoice.dto;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ClientProject {

	@Id
	@GeneratedValue
	private int mappedProjectId;
	
	@Column
	private String clientEmail;
	
	@Column
	private String billableType;
	
	@Column
	private Date startDate;
	
	@Column
	private File poDoc;
	
	@Column
	private File sowDoc;
	
	@Column
	private File woDoc;
	
	@Column
	private int empId;
	
	@Column
	private int projId;
		
}
