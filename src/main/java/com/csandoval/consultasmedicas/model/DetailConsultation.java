package com.csandoval.consultasmedicas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class DetailConsultation
{

	@Id
	@Column
	private Integer id;
	
	@Column
	private MedicalConsultation consultation;
	
	@Column
	private String diagnostic;
	
	@Column
	private String treatment;
}
