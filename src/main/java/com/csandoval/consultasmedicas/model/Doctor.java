package com.csandoval.consultasmedicas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Doctor
{

	@Id
	@Column
	private Integer id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String DNI;

	@Column
	private String medicalCode;
}
