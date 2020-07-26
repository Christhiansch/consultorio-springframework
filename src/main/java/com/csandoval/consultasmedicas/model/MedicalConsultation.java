package com.csandoval.consultasmedicas.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class MedicalConsultation
{

	@Id
	@Column
	private Integer id;

	@Column
	private LocalDateTime consultationDate;

	@Column
	private Doctor doctor;

	@Column
	private Patient patient;
}
